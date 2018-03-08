package com.example.micaelleal.projetoboletimescolar;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.micaelleal.projetoboletimescolar.adapters.NotasBimestreRvAdapter;
import com.example.micaelleal.projetoboletimescolar.dal.App;
import com.example.micaelleal.projetoboletimescolar.model.Disciplina;
import com.example.micaelleal.projetoboletimescolar.model.NotasBimestre;
import com.example.micaelleal.projetoboletimescolar.model.Usuario;

import java.util.List;

import io.objectbox.Box;

public class DisciplinaActivity extends AppCompatActivity {

    private TextView textDiciplina;
    private TextView textProfessor;
    private TextView textSituacao;
    private TextView textRecuperacao;
    private TextView textMediaFinal;
    private RecyclerView rvNotasBimestre;

    Box<Usuario> usuarioBox;
    private Box<Disciplina> disciplinaBox;
    private Disciplina disciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplina);

        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        disciplinaBox = ((App) getApplication()).getBoxStore().boxFor(Disciplina.class);
        disciplina = disciplinaBox.get(getIntent()
                .getLongExtra("disciplinaId", -1));

        setupViews();
        settarTextsPrincipais();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Box<NotasBimestre> notasBimestreBox = ((App) getApplication()).getBoxStore()
                .boxFor(NotasBimestre.class);

        NotasBimestreRvAdapter adapter = new NotasBimestreRvAdapter(this,
                disciplina.notasAnoLetivo, notasBimestreBox, obterUsuarioLogado());

        rvNotasBimestre.setAdapter(adapter);
        rvNotasBimestre.setLayoutManager(new LinearLayoutManager(this));
        rvNotasBimestre.setHasFixedSize(true);

    }

    private void settarTextsPrincipais() {
        Usuario usuario = obterUsuarioLogado();
        double media = disciplina.getMediaFinal();
        double recuperacao = disciplina.getRecuperacaoFinal();

        textDiciplina.setText(disciplina.getNome());
        textProfessor.setText(disciplina.getProfessor());

        if (media >= 0) {
            textMediaFinal.setText("Media final: "+ disciplina.getMediaFinal());
            if (recuperacao >= 0) {
                textRecuperacao.setVisibility(View.VISIBLE);
                if (recuperacao >= usuario.getMediaEscolar()) {
                    textRecuperacao.setVisibility(View.VISIBLE);
                    textRecuperacao.setText(""+recuperacao);
                    textSituacao.setText("Aprovado por recuperação.");
                } else {
                    textSituacao.setText("Reprovado meu parceiro!");
                }
            } else {
                if (media >= usuario.getMediaEscolar()) {
                    textSituacao.setText("Aprovado. Parabésn!!");
                } else {
                    textSituacao.setText("Recuperação final.");
                    textRecuperacao.setVisibility(View.VISIBLE);
                }
            }
        } else {
            textMediaFinal.setText("Media final: ");
        }

        Toast.makeText(this, ""+obterUsuarioLogado().getMediaEscolar(), Toast.LENGTH_SHORT).show();

        textRecuperacao.setOnClickListener((view) -> {
            View inflater = getLayoutInflater().inflate(R.layout.dialog_add_nota, null);
            EditText editNota = inflater.findViewById(R.id.edit_add_nota);

            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setView(inflater)
                    .setTitle("Nota: ")
                    .setNegativeButton("Cancelar", (dialog, id) -> {dialog.dismiss();})
                    .setPositiveButton("Ok", (dialog, id) -> {
                        String nota = editNota.getText().toString();
                        if (!nota.isEmpty()) {
                            disciplina.setRecuperacaoFinal(Double.parseDouble(nota));
                            disciplinaBox.put(disciplina);
                        }
                    });
            builder.show();
        });

        onResume();

    }

    private void setupViews() {
        textDiciplina = findViewById(R.id.text_disciplina_nome);
        textProfessor = findViewById(R.id.text_disciplina_professor);
        rvNotasBimestre = findViewById(R.id.rv_bimestre_disciplina);
        textSituacao = findViewById(R.id.text_diciplina_situacao);
        textRecuperacao = findViewById(R.id.text_disciplina_recuperacao);
        textMediaFinal = findViewById(R.id.medial_final);
    }

    private Usuario obterUsuarioLogado() {
        final long usuarioId = getSharedPreferences("appnotas.file", MODE_PRIVATE)
                .getLong("usuarioId", -1);
        return (usuarioId == -1) ? null : usuarioBox.get(usuarioId);
    }
}
