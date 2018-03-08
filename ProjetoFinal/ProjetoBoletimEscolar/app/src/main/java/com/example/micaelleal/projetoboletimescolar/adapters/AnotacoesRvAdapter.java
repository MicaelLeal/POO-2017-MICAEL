package com.example.micaelleal.projetoboletimescolar.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.micaelleal.projetoboletimescolar.FormularioAnotacaoActivity;
import com.example.micaelleal.projetoboletimescolar.R;
import com.example.micaelleal.projetoboletimescolar.model.Anotacao;

import java.util.Collections;
import java.util.List;

import io.objectbox.Box;

/**
 * Created by micaelleal on 02/03/18.
 */

public class AnotacoesRvAdapter extends RecyclerView.Adapter<AnotacoesRvAdapter.ViewHolder> {

    private Context context;
    private Box<Anotacao> anotacaoBox;
    private List<Anotacao> anotacoes;

    public AnotacoesRvAdapter(Context context, Box<Anotacao> anotacaoBox, List<Anotacao> anotacoes) {
        this.context = context;
        this.anotacaoBox = anotacaoBox;
        Collections.sort(anotacoes);
        this.anotacoes = anotacoes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_anotacao, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Anotacao anotacao = anotacoes.get(position);

        holder.txtDescricao.setText(anotacao.getTitulo());
        holder.txtData.setText(anotacao.getData());
        holder.txtConteudo.setText(context.getString(R.string.str_anotacoes_conteudo)+ anotacao.getConteudo());

        managerClicks(holder);
        managerLongClicks(holder, position, anotacao);

    }

    @Override
    public int getItemCount() {
        return anotacoes.size();
    }

    private void managerClicks(ViewHolder holder) {
        holder.itemView.setOnClickListener((view) -> {
            if (holder.expandido) {
                holder.txtConteudo.setVisibility(View.GONE);
                holder.btnExpandir.setImageResource(R.mipmap.ic_launcher_expand_more);
                holder.txtDescricao.setMaxLines(1);
                holder.expandido = false;
            } else {
                holder.txtConteudo.setVisibility(View.VISIBLE);
                holder.btnExpandir.setImageResource(R.mipmap.ic_launcher_expand_less);
                holder.txtDescricao.setMaxLines(2);
                holder.expandido = true;
            }
        });
    }

    private void managerLongClicks(ViewHolder holder, int position, Anotacao anotacao) {
        holder.itemView.setOnLongClickListener((view) -> {

            PopupMenu popupMenu = new PopupMenu(context, view);
            popupMenu.getMenuInflater().inflate(R.menu.menu_popup_rv_item, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener((menuItem) -> {

                switch (menuItem.getItemId()) {
                    case R.id.item_popup_editar:
                        context.startActivity(new Intent(context, FormularioAnotacaoActivity.class)
                                .putExtra("anotacaoId", anotacao.getId()));
                        break;

                    case R.id.item_popup_deletar:
                        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                                .setTitle(R.string.anotacao_dialog_titulo_deletar)
                                .setMessage(R.string.anotacao_dialog_message_deletar)
                                .setPositiveButton(R.string.anotacao_dialog_positive, (dialog, i) -> {

                                    anotacaoBox.remove(anotacao);
                                    anotacoes.remove(anotacao);
                                    notifyItemRemoved(position);
                                    notifyItemRangeChanged(position, getItemCount());

                                    Toast.makeText(context, R.string.anotacao_dialog_toast, Toast.LENGTH_SHORT).show();

                                }).setNegativeButton(R.string.anotacao_dialog_negative, (dilog, i) -> {dilog.dismiss();});
                        builder.create().show();
                        break;
                }
                return true;
            });
            popupMenu.show();
            return true;
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected boolean expandido;
        protected TextView txtDescricao;
        protected TextView txtData;
        protected TextView txtConteudo;
        protected ImageView btnExpandir;

        public ViewHolder(View itemView) {
            super(itemView);

            expandido = false;
            txtDescricao = itemView.findViewById(R.id.text_item_anotacao_descricao);
            txtData = itemView.findViewById(R.id.text_item_anotacao_data);
            txtConteudo = itemView.findViewById(R.id.text_item_anotacao_conteudo);
            btnExpandir = itemView.findViewById(R.id.btn_expand_anotacao);
        }
    }

}
