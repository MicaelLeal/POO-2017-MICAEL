package com.example.micaelleal.projetoboletimescolar.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.micaelleal.projetoboletimescolar.DisciplinaActivity;
import com.example.micaelleal.projetoboletimescolar.FormularioDisciplinaActivity;
import com.example.micaelleal.projetoboletimescolar.R;
import com.example.micaelleal.projetoboletimescolar.model.Disciplina;

import java.util.Collections;
import java.util.List;

import io.objectbox.Box;

/**
 * Created by micaelleal on 18/02/18.
 */

public class DisciplinasRvAdapter extends RecyclerView.Adapter<DisciplinasRvAdapter.ViewHolder> {

    private Context context;
    private Box<Disciplina> disciplinaBox;
    private List<Disciplina> disciplinas;

    public DisciplinasRvAdapter(Context context, Box<Disciplina> disciplinaBox,
                                List<Disciplina> disciplinas) {
        this.context = context;
        this.disciplinaBox = disciplinaBox;
        Collections.sort(disciplinas);
        this.disciplinas = disciplinas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_disciplina, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Disciplina disciplina = disciplinas.get(position);

        holder.txtNomeDisciplina.setText(disciplina.getNome());
        holder.txtProfessor.setText("Prof.: "+ disciplina.getProfessor());

        managerClicks(holder, disciplina);
        managerLongClicks(holder, position, disciplina);

    }

    @Override
    public int getItemCount() {
        return (int) disciplinas.size();
    }

    private void managerClicks(final ViewHolder holder, Disciplina disciplina) {

        holder.itemView.setOnClickListener((view) -> {
            context.startActivity(new Intent(context, DisciplinaActivity.class)
                    .putExtra("disciplinaId", disciplina.getId()));
        });
    }

    private void managerLongClicks(ViewHolder holder, int position, Disciplina disciplina) {
        holder.itemView.setOnLongClickListener((view) -> {
            PopupMenu popupMenu = new PopupMenu(context, view);
            popupMenu.getMenuInflater().inflate(R.menu.menu_popup_rv_item, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener((menuItem) -> {

                switch (menuItem.getItemId()) {
                    case R.id.item_popup_editar:
                        context.startActivity(new Intent(context, FormularioDisciplinaActivity.class)
                                .putExtra("disciplinaId", disciplina.getId()));
                        break;

                    case R.id.item_popup_deletar:
                        AlertDialog.Builder builder = new AlertDialog.Builder(context).setTitle("Deletar")
                                .setMessage("Deseja mesmo remover "+ disciplina.getNome() +" das suas disciplinas?")
                                .setPositiveButton("Sim", (dialog, i) -> {

                                    disciplinas.remove(disciplina);
                                    disciplinaBox.remove(disciplina);
                                    notifyItemRemoved(position);
                                    notifyItemRangeChanged(position, getItemCount());

                                    Toast.makeText(context, "Ítem removido", Toast.LENGTH_SHORT).show();

                                }).setNegativeButton("Não", (dialog, i) -> {dialog.dismiss();});
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

        protected TextView txtNomeDisciplina;
        protected TextView txtProfessor;

        public ViewHolder(View itemView) {
            super(itemView);

            txtNomeDisciplina = itemView.findViewById(R.id.txt_card_disciplina);
            txtProfessor = itemView.findViewById(R.id.txt_card_professor);

        }
    }
}
