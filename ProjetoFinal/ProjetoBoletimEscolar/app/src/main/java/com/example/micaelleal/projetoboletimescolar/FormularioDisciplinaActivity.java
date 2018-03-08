package com.example.micaelleal.projetoboletimescolar;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.micaelleal.projetoboletimescolar.dal.App;
import com.example.micaelleal.projetoboletimescolar.exceptions.StringVaziaException;
import com.example.micaelleal.projetoboletimescolar.model.Disciplina;
import com.example.micaelleal.projetoboletimescolar.model.NotasBimestre;
import com.example.micaelleal.projetoboletimescolar.model.Usuario;
import com.example.micaelleal.projetoboletimescolar.utils.ValidadorDeCampos;

import io.objectbox.Box;

public class FormularioDisciplinaActivity extends AppCompatActivity {

    private EditText editDisciplina;
    private EditText editProfessor;

    private Box<Disciplina> disciplinaBox;
    private Box<Usuario> usuarioBox;
    private Disciplina disciplina;
    private Usuario usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_disciplina);

        setupViews();

        disciplinaBox = ((App) getApplication()).getBoxStore().boxFor(Disciplina.class);
        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        usuarioLogado = obterUsuarioLogado();

        long disciplinaId = getIntent().getLongExtra("disciplinaId", -1);

        if (disciplinaId != -1) {
            disciplina = disciplinaBox.get(disciplinaId);
            editDisciplina.setText(disciplina.getNome());
            editProfessor.setText(disciplina.getProfessor());
        } else {
            disciplina = new Disciplina();
            for (int i = 1; i <= 4; i++) {
                disciplina.notasAnoLetivo.add(new NotasBimestre(i, usuarioLogado));
            }
        }
    }

    public void concluir(View view) {
        try {
            ValidadorDeCampos.validarString(editDisciplina.getText().toString(),
                    editProfessor.getText().toString());

            disciplina.setNome(editDisciplina.getText().toString());
            disciplina.setProfessor(editProfessor.getText().toString());
            disciplina.getUsuarioDono().setTarget(usuarioLogado);

            disciplinaBox.put(disciplina);

            usuarioLogado.notas.addAll(disciplina.notasAnoLetivo);
            usuarioBox.put(usuarioLogado);

            Toast.makeText(this, "Concluído", Toast.LENGTH_SHORT).show();
            finish();

        } catch (StringVaziaException e) {
            /** Esconde teclado antes de mostrar snackbar */
            ((InputMethodManager) view.getContext()
                    .getSystemService(view.getContext().INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(editDisciplina.getWindowToken(), 0);
            Snackbar.make(view, "Preencha corretamente os campos", Snackbar.LENGTH_SHORT)
                    .show();
        }
    }

    private Usuario obterUsuarioLogado() {
        final long id = getSharedPreferences("appnotas.file", MODE_PRIVATE)
                .getLong("usuarioId", -1);
        return usuarioBox.get(id);
    }

    private void setupViews() {
        editDisciplina = findViewById(R.id.edit_add_disciplina_nome);
        editProfessor = findViewById(R.id.edit_add_disciplina_professor);
    }
}
