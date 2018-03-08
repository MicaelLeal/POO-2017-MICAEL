package com.example.micaelleal.projetoboletimescolar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.micaelleal.projetoboletimescolar.dal.App;
import com.example.micaelleal.projetoboletimescolar.exceptions.ConfirmacaoSenhaIncorretaException;
import com.example.micaelleal.projetoboletimescolar.exceptions.EmailInvalidoException;
import com.example.micaelleal.projetoboletimescolar.exceptions.StringVaziaException;
import com.example.micaelleal.projetoboletimescolar.exceptions.UsuarioExistenteException;
import com.example.micaelleal.projetoboletimescolar.model.Usuario;
import com.example.micaelleal.projetoboletimescolar.model.Usuario_;
import com.example.micaelleal.projetoboletimescolar.utils.ValidadorDeCampos;

import java.util.List;

import io.objectbox.Box;

public class LoginActivity extends AppCompatActivity {

    /** Usado para troca de layouts */
    private static boolean sIsLayoutlogin = true;

    /** Fields de login. */
    private EditText editLoginEmail;
    private EditText editLoginSenha;

    /** Fields de cadastro */
    private EditText editCadastroNome;
    private EditText editCadastroEscola;
    private EditText editCadastroEmail;
    private EditText editCadastroSenha;;
    private EditText editcadastroConfirmaSenha;

    private Box<Usuario> usuarioBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        callSetContentView();

        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
    }

    @Override
    public void onBackPressed() {

        if (sIsLayoutlogin) {
            super.onBackPressed();
        } else {
            sIsLayoutlogin = true;
            callSetContentView();
        }

    }

    public void trocaLayoutParaCadastro(View view) {
        sIsLayoutlogin = false;
        callSetContentView();
    }

    public void solicitarLogin(View view) {
        final String email = editLoginEmail.getText().toString();
        final String senha = editLoginSenha.getText().toString();

        final List<Usuario> resultado = usuarioBox.query()
                .equal(Usuario_.email, email)
                .equal(Usuario_.senha, senha)
                .build()
                .find();

        if (resultado.isEmpty()) {
            Toast.makeText(this, "Email e/ou senha incorreto(s)!", Toast.LENGTH_SHORT)
                    .show();
        } else {
            logar(resultado.get(0));
        }

    }

    public void cadastrar(View view) {

        try {
            String email = editCadastroEmail.getText().toString();
            String senha = editCadastroSenha.getText().toString();

            ValidadorDeCampos.validarString(editCadastroNome.getText().toString(),
                    editCadastroEscola.getText().toString(), senha);
            ValidadorDeCampos.validarEmail(email);
            ValidadorDeCampos.validarConfirmacaoDeSenha(senha,
                    editcadastroConfirmaSenha.getText().toString());
            ValidadorDeCampos.verificarSeExixtente(usuarioBox.getAll(), email);

            Usuario usuario = new Usuario(email, senha);
            usuario.setNome(editCadastroNome.getText().toString());
            usuario.setEscola(editCadastroEscola.getText().toString());

            usuarioBox.put(usuario);

            logar(usuario);

        } catch (StringVaziaException e) {
            Snackbar.make(view, "Preencha todos os campos!", Snackbar.LENGTH_SHORT).show();
        } catch (EmailInvalidoException e) {
            Snackbar.make(view, "E-mail inválido!", Snackbar.LENGTH_SHORT).show();
        } catch (ConfirmacaoSenhaIncorretaException e) {
            Snackbar.make(view, "Senhas não coincidem!", Snackbar.LENGTH_SHORT).show();
        } catch (UsuarioExistenteException e) {
            Snackbar.make(view, "Email já cadastrado!", Snackbar.LENGTH_SHORT).show();
        }

    }

    private void logar(Usuario usuario) {
        SharedPreferences preferences = getSharedPreferences("appnotas.file", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putLong("usuarioId", usuario.getId());
        editor.commit();

        startActivity(new Intent(this, MainActivity.class));
        sIsLayoutlogin = true;
        finish();
    }

    /** Seleciona layout a ser exibido */
    private void callSetContentView() {
        if (sIsLayoutlogin) {
            setContentView(R.layout.activity_login_logar);
        } else {
            setContentView(R.layout.activity_login_cadastrar);
        }
        setupViews();
    }

    private void setupViews() {
        editLoginEmail = findViewById(R.id.edit_login_email);
        editLoginSenha = findViewById(R.id.edit_login_senha);
        editCadastroNome = findViewById(R.id.edit_cadastrar_nome);
        editCadastroEscola = findViewById(R.id.edit_cadastrar_escola);
        editCadastroEmail = findViewById(R.id.edit_cadastrar_email);
        editCadastroSenha = findViewById(R.id.edit_cadastrar_senha);
        editcadastroConfirmaSenha = findViewById(R.id.edit_cadastrar_confirma_senha);
    }
}
