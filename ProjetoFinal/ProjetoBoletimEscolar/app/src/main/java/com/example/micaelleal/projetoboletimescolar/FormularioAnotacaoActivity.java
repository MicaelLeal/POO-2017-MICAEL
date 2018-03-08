package com.example.micaelleal.projetoboletimescolar;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.micaelleal.projetoboletimescolar.dal.App;
import com.example.micaelleal.projetoboletimescolar.exceptions.StringVaziaException;
import com.example.micaelleal.projetoboletimescolar.model.Anotacao;
import com.example.micaelleal.projetoboletimescolar.model.Usuario;
import com.example.micaelleal.projetoboletimescolar.utils.ValidadorDeCampos;

import io.objectbox.Box;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class FormularioAnotacaoActivity extends AppCompatActivity {

    private EditText editTitulo;
    private TextView textData;
    private EditText editConteudo;

    private Box<Anotacao> anotacaoBox;
    private Box<Usuario> usuarioBox;
    private Anotacao anotacao;
    private Usuario usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_anotacao);

        setupViews();

        anotacaoBox = ((App) getApplication()).getBoxStore().boxFor(Anotacao.class);
        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        usuarioLogado = obterUsuarioLogado();

        final long anotacaoId = getIntent().getLongExtra("anotacaoId", -1);

        if (anotacaoId != -1) {
            anotacao = anotacaoBox.get(anotacaoId);
            editTitulo.setText(anotacao.getTitulo());
            textData.setText(anotacao.getData());
            editConteudo.setText(anotacao.getConteudo());
        } else {
            anotacao = new Anotacao();
        }

    }

    public void selecionarData(View view) {

        final Calendar calendario = Calendar.getInstance();
        int ano = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (datePicker, i, i1, i2) -> {
                    calendario.set(i, i1, i2);
                    textData.setText(new SimpleDateFormat("dd - MMMM - yyyy")
                            .format(calendario.getTime()));
                }, ano, mes, dia);

        /** Definir data mínima a ser escolhida sendo a data atual */
        datePickerDialog.getDatePicker().setMinDate(calendario.getTimeInMillis());
        datePickerDialog.show();
    }

    public void concluir(View view) {

        try {
            ValidadorDeCampos.validarString(editTitulo.getText().toString(),
                    textData.getText().toString());

            anotacao.setTitulo(editTitulo.getText().toString());
            anotacao.setData(textData.getText().toString());
            anotacao.setConteudo(editConteudo.getText().toString());
            anotacao.getUsuarioDono().setTarget(usuarioLogado);

            anotacaoBox.put(anotacao);

            Toast.makeText(this, "Concluído", Toast.LENGTH_SHORT).show();
            finish();

        } catch (StringVaziaException e) {
            Snackbar.make(view, "Preencha os campos obrigatórios (*)", Snackbar.LENGTH_SHORT)
                    .show();
        }

    }

    private Usuario obterUsuarioLogado() {

        final SharedPreferences preferences =
                getSharedPreferences("appnotas.file", MODE_PRIVATE);

        final long usuarioId = preferences.getLong("usuarioId", -1);
        return usuarioBox.get(usuarioId);

    }

    private void setupViews() {
        editTitulo = findViewById(R.id.edit_add_anotacao_titulo);
        textData = findViewById(R.id.text_add_anotacao_data);
        editConteudo = findViewById(R.id.edit_add_anotacao_conteudo);
    }

}
