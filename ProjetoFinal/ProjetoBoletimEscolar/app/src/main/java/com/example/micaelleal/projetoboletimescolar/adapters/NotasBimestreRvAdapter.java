package com.example.micaelleal.projetoboletimescolar.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.micaelleal.projetoboletimescolar.R;
import com.example.micaelleal.projetoboletimescolar.exceptions.EmailInvalidoException;
import com.example.micaelleal.projetoboletimescolar.exceptions.SenhaIncorretaException;
import com.example.micaelleal.projetoboletimescolar.model.Disciplina;
import com.example.micaelleal.projetoboletimescolar.model.NotasBimestre;
import com.example.micaelleal.projetoboletimescolar.model.Usuario;
import com.example.micaelleal.projetoboletimescolar.utils.ValidadorDeCampos;

import java.util.List;

import io.objectbox.Box;

/**
 * Created by micaelleal on 06/03/18.
 */

public class NotasBimestreRvAdapter extends RecyclerView.Adapter<NotasBimestreRvAdapter.ViewHolder> {

    private Context context;
    private List<NotasBimestre> bimestres;
    private Box<NotasBimestre> notasBimestreBox;
    private Usuario usuarioLogado;

    public NotasBimestreRvAdapter(Context context, List<NotasBimestre> bimestres,
                                  Box<NotasBimestre> notasBimestreBox, Usuario usuarioLogado) {
        this.context = context;
        this.bimestres = bimestres;
        this.notasBimestreBox = notasBimestreBox;
        this.usuarioLogado = usuarioLogado;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_bimestre_disciplina, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        NotasBimestre bimestre = bimestres.get(position);

        holder.mBimestre.setText(bimestre.getBimestreId() +"º Bimestre");
        holder.mMedia.setText((bimestre.getMedia()) < 0
                ? "" : String.format("%.1f", bimestre.getMedia()));
        holder.mPontos.setText(bimestre.getPontos() <= 0
                ? "" : String.format("%.1f", bimestre.getPontos()));
        holder.mNotaMensal.setText((bimestre.getNotaMensal()) < 0
                ? "" : String.format("%.1f", bimestre.getNotaMensal()));
        if (bimestre.getNotaBimestral() < 0) {
            holder.mNotaBimestral.setHint(holder.mNotaMensal.getText());
        } else {
            holder.mNotaBimestral.setText(String.format("%.1f", bimestre.getNotaBimestral()));
        }
        holder.mNotaRecuperacao.setText(bimestre.getRecuperacao() < 0
                ? "" : String.format("%.1f", bimestre.getRecuperacao()));

        if (bimestre.getNotaMensal() >= 0) {
            setClickNotaBimestral(holder, bimestre, position);
        }
        if (bimestre.getMedia() >= 0) {
            if (bimestre.getMedia() < usuarioLogado.getMediaEscolar()) {
                setClickNotaRecuperacao(holder, bimestre, position);
            }
            setClickPontos(holder, bimestre, position);
        }
        settarCores(holder, bimestre, position);
        gerenciarClicks(holder, bimestre, position);

    }

    private void gerenciarClicks(ViewHolder holder, NotasBimestre bimestre, int position) {
        if (bimestre.getMedia() < 0) {
            holder.mNotaMensal.setVisibility(View.GONE);
            holder.mEdit.setVisibility(View.VISIBLE);
        }


        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Nota: ");
        builder.setNegativeButton("Cancelar", (dialog, id) -> {dialog.dismiss();});

        holder.mEdit.setOnClickListener((view) -> {
            View inflater = ((Activity)context).getLayoutInflater()
                    .inflate(R.layout.dialog_add_nota, null);
            EditText editNota = inflater.findViewById(R.id.edit_add_nota);
            builder.setView(inflater);
            builder.setPositiveButton("Ok", (dialog, id) -> {
                String nota = editNota.getText().toString();
                if (!nota.isEmpty()) {
                    bimestre.setNotaMensal(Double.parseDouble(nota));
                    notasBimestreBox.put(bimestre);
                    notifyItemChanged(position);
                    holder.mEdit.setVisibility(View.GONE);
                    holder.mNotaMensal.setVisibility(View.VISIBLE);
                    holder.mNotaBimestral.setClickable(true);
                }
            });
            builder.create().show();
        });
        holder.mNotaMensal.setOnClickListener((view) -> {
            View inflater = ((Activity)context).getLayoutInflater()
                    .inflate(R.layout.dialog_add_nota, null);
            EditText editNota = inflater.findViewById(R.id.edit_add_nota);
            builder.setView(inflater);
            builder.setPositiveButton("Ok", (dialog, id) -> {
                String nota = editNota.getText().toString();
                if (!nota.isEmpty()) {
                    bimestre.setNotaMensal(Double.parseDouble(nota));
                    notasBimestreBox.put(bimestre);
                    notifyItemChanged(position);
                }
            });
            builder.create().show();
        });
    }

    private void setClickPontos(ViewHolder holder, NotasBimestre bimestre, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Pontos: ");
        builder.setNegativeButton("Cancelar", (dialog, id) -> {dialog.dismiss();});

        holder.mPontos.setOnClickListener((view) -> {
            View inflater = ((Activity) context).getLayoutInflater()
                    .inflate(R.layout.dialog_add_nota, null);
            EditText editNota = inflater.findViewById(R.id.edit_add_nota);
            builder.setView(inflater);
            builder.setPositiveButton("Ok", (dialog, id) -> {
                String nota = editNota.getText().toString();
                if (!nota.isEmpty()) {
                    bimestre.setPontos(Double.parseDouble(nota));
                    notasBimestreBox.put(bimestre);
                    notifyItemChanged(position);
                }
            });
            builder.create().show();
        });
    }

    private void setClickNotaRecuperacao(ViewHolder holder, NotasBimestre bimestre, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Nota: ");
        builder.setNegativeButton("Cancelar", (dialog, id) -> {dialog.dismiss();});

        holder.mNotaRecuperacao.setOnClickListener((view) -> {
            View inflater = ((Activity) context).getLayoutInflater()
                    .inflate(R.layout.dialog_add_nota, null);
            EditText editNota = inflater.findViewById(R.id.edit_add_nota);
            builder.setView(inflater);
            builder.setPositiveButton("Ok", (dialog, id) -> {
                String nota = editNota.getText().toString();
                if (!nota.isEmpty()) {
                    bimestre.setRecuperacao(Double.parseDouble(nota));
                    notasBimestreBox.put(bimestre);
                    notifyItemChanged(position);
                }
            });
            builder.create().show();
        });
    }

    private void setClickNotaBimestral(ViewHolder holder, NotasBimestre bimestre, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Nota: ");
        builder.setNegativeButton("Cancelar", (dialog, id) -> {dialog.dismiss();});

        holder.mNotaBimestral.setOnClickListener((view) -> {
            View inflater = ((Activity)context).getLayoutInflater()
                    .inflate(R.layout.dialog_add_nota, null);
            EditText editNota = inflater.findViewById(R.id.edit_add_nota);
            builder.setView(inflater);
            builder.setPositiveButton("Ok", (dialog, id) -> {
                String nota = editNota.getText().toString();
                if (!nota.isEmpty()) {
                    bimestre.setNotaBimestral(Double.parseDouble(nota));
                    notasBimestreBox.put(bimestre);
                    notifyItemChanged(position);
                }
            });
            builder.create().show();
        });
    }

    @SuppressLint("ResourceAsColor")
    private void settarCores(ViewHolder holder, NotasBimestre bimestre, int position) {
        if (bimestre.getMedia() < usuarioLogado.getMediaEscolar()) {
            holder.mMedia.setTextColor(Color.RED);
        } else if (bimestre.getMedia() < usuarioLogado.getMediaPessoal()) {
            holder.mMedia.setTextColor(Color.YELLOW);
        } else {
            holder.mMedia.setTextColor(Color.BLUE);
        }

        if (bimestre.getNotaMensal() < usuarioLogado.getMediaEscolar()) {
            holder.mNotaMensal.setTextColor(Color.RED);
        } else if (bimestre.getNotaMensal() < usuarioLogado.getMediaPessoal()) {
            holder.mNotaMensal.setTextColor(Color.YELLOW);
        } else {
            holder.mNotaMensal.setTextColor(Color.BLUE);
        }

        if (bimestre.getNotaBimestral() < usuarioLogado.getMediaEscolar()) {
            holder.mNotaBimestral.setTextColor(Color.RED);
        } else if (bimestre.getNotaBimestral() < usuarioLogado.getMediaPessoal()) {
            holder.mNotaBimestral.setTextColor(Color.YELLOW);
        } else {
            holder.mNotaBimestral.setTextColor(Color.BLUE);
        }

        if (bimestre.getRecuperacao() < usuarioLogado.getMediaEscolar()) {
            holder.mNotaRecuperacao.setTextColor(Color.RED);
        } else if (bimestre.getRecuperacao() < usuarioLogado.getMediaPessoal()) {
            holder.mNotaRecuperacao.setTextColor(Color.YELLOW);
        } else {
            holder.mNotaRecuperacao.setTextColor(Color.BLUE);
        }
    }

    @Override
    public int getItemCount() {
        return bimestres.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView mBimestre;
        protected TextView mMedia;
        protected TextView mPontos;
        protected TextView mNotaMensal;
        protected TextView mNotaBimestral;
        protected TextView mNotaRecuperacao;
        protected ImageButton mEdit;

        public ViewHolder(View itemView) {
            super(itemView);

            mBimestre = itemView.findViewById(R.id.text_item_notas_titulo);
            mMedia = itemView.findViewById(R.id.text_item_notas_media);
            mPontos = itemView.findViewById(R.id.text_item_notas_nota_pontos);
            mNotaMensal = itemView.findViewById(R.id.text_item_notas_nota_mensal);
            mNotaBimestral = itemView.findViewById(R.id.text_item_notas_nota_bimestral);
            mNotaRecuperacao = itemView.findViewById(R.id.text_item_notas_nota_recuperacao);
            mEdit = itemView.findViewById(R.id.item_bimestre_image);

        }
    }

}
