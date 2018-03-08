package com.example.micaelleal.projetoboletimescolar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.micaelleal.projetoboletimescolar.adapters.ViewPagerAdapter;
import com.example.micaelleal.projetoboletimescolar.dal.App;
import com.example.micaelleal.projetoboletimescolar.exceptions.ConfirmacaoSenhaIncorretaException;
import com.example.micaelleal.projetoboletimescolar.exceptions.EmailInvalidoException;
import com.example.micaelleal.projetoboletimescolar.exceptions.SenhaIncorretaException;
import com.example.micaelleal.projetoboletimescolar.exceptions.StringVaziaException;
import com.example.micaelleal.projetoboletimescolar.fragments.AgendaFragment;
import com.example.micaelleal.projetoboletimescolar.fragments.DisciplinasFragment;
import com.example.micaelleal.projetoboletimescolar.model.Anotacao;
import com.example.micaelleal.projetoboletimescolar.model.Anotacao_;
import com.example.micaelleal.projetoboletimescolar.model.Disciplina;
import com.example.micaelleal.projetoboletimescolar.model.Disciplina_;
import com.example.micaelleal.projetoboletimescolar.model.NotasBimestre;
import com.example.micaelleal.projetoboletimescolar.model.Usuario;
import com.example.micaelleal.projetoboletimescolar.utils.ValidadorDeCampos;

import java.util.List;

import io.objectbox.Box;

public class MainActivity extends AppCompatActivity {

    private ViewPagerAdapter adapter;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavigationView;

    private Box<Usuario> usuarioBox;
    private Usuario usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializador();
        gerenciarClicksNaGaveta();

    }

    @Override
    protected void onResume() {
        super.onResume();
        ViewPager viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mToggle.onOptionsItemSelected(item) ? true : super.onOptionsItemSelected(item);
    }

    public void adicionarDisciplina(View view) {
        startActivity(new Intent(this, FormularioDisciplinaActivity.class));
    }

    public void adicionarAnotacao(View view) {
        startActivity(new Intent(this, FormularioAnotacaoActivity.class));
    }

    /** Retorna fragmento atual com base na posicao. */
    public Fragment getFragment(int pos) {
        return adapter.getItem(pos);
    }

    /** Verifica se há usuario logado, inicializa atributos */
    private void inicializador() {
        if (!logado()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

        usuarioBox = ((App) getApplication()).getBoxStore().boxFor(Usuario.class);
        usuarioLogado = obterUsuarioLogado();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /** Drawer */
        mDrawer = findViewById(R.id.drawer_main);
        mToggle = new ActionBarDrawerToggle(this,
                mDrawer, R.string.open_drawer, R.string.close_drawer);
        mDrawer.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void gerenciarClicksNaGaveta() {
        mNavigationView = findViewById(R.id.navigation_view_main);
        mNavigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_drawer_editar_perfil:
                    editarPerfil();
                    return true;

                case R.id.menu_drawer_trocar_email:
                    trocarEmail();
                    return true;

                case R.id.menu_drawer_trocar_senha:
                    trocarSenha();
                    return true;

                case R.id.menu_drawer_reset:
                    resetarConta();
                    return true;

                case R.id.menu_drawer_remover_conta:
                    removerConta();
                    return true;

                case R.id.menu_drawer_logout:
                    logout();
                    return true;
            }
            return false;
        });
    }

    private void editarPerfil() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View inflate = getLayoutInflater().inflate(R.layout.dialog_editar_perfil, null);

        EditText editEscola = inflate.findViewById(R.id.edit_editar_perfil_escola);
        EditText editNome = inflate.findViewById(R.id.edit_editar_perfil_nome);
        EditText editMediaEscolar = inflate.findViewById(R.id.edit_editar_perfil_media_escolar);
        EditText editMediaPessoal = inflate.findViewById(R.id.edit_editar_perfil_media_pessoal);

        editEscola.setText(usuarioLogado.getEscola());
        editNome.setText(usuarioLogado.getNome());
        editMediaEscolar.setText(""+usuarioLogado.getMediaEscolar());
        editMediaPessoal.setText(""+usuarioLogado.getMediaPessoal());

        builder.setTitle("Editar perfil").setView(inflate);
        builder.setPositiveButton("Ok", (dialog, id) -> {

            try {
                String escola = editEscola.getText().toString();
                String nome = editNome.getText().toString();
                String mediaEscolar = editMediaEscolar.getText().toString();
                String mediaPessoal = editMediaPessoal.getText().toString();

                ValidadorDeCampos.validarString(editEscola.getText().toString(), nome);
                usuarioLogado.setEscola(escola);
                usuarioLogado.setNome(nome);

                if (!mediaEscolar.isEmpty()) {
                    usuarioLogado.setMediaEscolar(Double.parseDouble(mediaEscolar));
                }
                if (!mediaPessoal.isEmpty()) {
                    usuarioLogado.setMediaPessoal(Double.parseDouble(mediaPessoal));
                }

                usuarioBox.put(usuarioLogado);


            } catch (StringVaziaException e) {
                Toast.makeText(this, "Preencha os campos obrigatórios", Toast.LENGTH_SHORT).show();
                editarPerfil();
            }

        }).setNegativeButton("Cancelar", (dialog, id) -> {dialog.dismiss();}).show();

    }

    private void trocarEmail() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View inflate = getLayoutInflater().inflate(R.layout.dialog_alterar_email, null);

        EditText editSenha = inflate.findViewById(R.id.edit_alterar_email_senha);
        EditText editNovoEmail = inflate.findViewById(R.id.edit_alterar_email_novo);

        builder.setTitle("Alterar e-mail");
        builder.setView(inflate).setPositiveButton("Ok", (dialog, id) -> {
            String senha = editSenha.getText().toString();
            String novoEmail = editNovoEmail.getText().toString();

            try {
                ValidadorDeCampos.verificarSenha(senha, usuarioLogado.getSenha());
                ValidadorDeCampos.validarEmail(novoEmail);

                usuarioLogado.setEmail(novoEmail);
                usuarioBox.put(usuarioLogado);

                Toast.makeText(this, "E-mail alterado", Toast.LENGTH_SHORT).show();
                return;

            } catch (SenhaIncorretaException e) {
                Toast.makeText(this, "Senha incorreta!", Toast.LENGTH_SHORT).show();
            } catch (EmailInvalidoException e) {
                Toast.makeText(this, "E-mail inválido!", Toast.LENGTH_SHORT).show();
            }
            trocarEmail();

        }).setNegativeButton("Cancelar", (dialog, id) -> {dialog.dismiss();}).show();
    }

    private void trocarSenha() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        View inflate = getLayoutInflater().inflate(R.layout.dialog_alterar_senha, null);

        EditText editSenha = inflate.findViewById(R.id.edit_alterar_senha);
        EditText editNovaSenha = inflate.findViewById(R.id.edit_alterar_senha_nova);
        EditText editConfirmaSenha = inflate.findViewById(R.id.edit_alterar_senha_confirmar);

        builder.setTitle("Trocar senha");
        builder.setView(inflate).setPositiveButton("Ok", (dialog, id) -> {
            String senha = editSenha.getText().toString();
            String novaSenha = editNovaSenha.getText().toString();
            String senhaConfirm = editConfirmaSenha.getText().toString();

            try {
                ValidadorDeCampos.verificarSenha(senha, usuarioLogado.getSenha());
                ValidadorDeCampos.validarConfirmacaoDeSenha(novaSenha, senhaConfirm);

                usuarioLogado.setSenha(novaSenha);
                usuarioBox.put(usuarioLogado);

                Toast.makeText(this, "Senha alterada", Toast.LENGTH_SHORT).show();
                return;

            } catch (SenhaIncorretaException e) {
                Toast.makeText(this, "Senha incorreta!", Toast.LENGTH_SHORT).show();
            } catch (ConfirmacaoSenhaIncorretaException e) {
                Toast.makeText(this, "Senhas não coincidem!", Toast.LENGTH_SHORT).show();
            }
            trocarSenha();
        }).setNegativeButton("Cancelar", (dialog, id) -> {dialog.dismiss();}).show();

    }

    /** Instancia box de notas, disciplinas e anotações para remover
     *  itens referentes à usuarioLogado definitivamente do BD */
    private void resetarConta() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Deseja reiniciar sua conta? (isso apagará todas suas informações)")
                .setPositiveButton("Sim", (dialog, i) -> {

                    Box<NotasBimestre> notasBimestreBox = ((App) getApplication()).getBoxStore()
                            .boxFor(NotasBimestre.class);
                    Box<Disciplina> disciplinaBox = ((App) getApplication()).getBoxStore()
                            .boxFor(Disciplina.class);
                    Box<Anotacao> anotacaoBox = ((App) getApplication()).getBoxStore()
                            .boxFor(Anotacao.class);

                    List<Disciplina> disciplinas = disciplinaBox.query()
                            .equal(Disciplina_.usuarioDonoId, usuarioLogado.getId())
                            .build().find();
                    List<Anotacao> anotacoes = anotacaoBox.query()
                            .equal(Anotacao_.usuarioDonoId, usuarioLogado.getId())
                            .build().find();

                    notasBimestreBox.remove(usuarioLogado.notas);
                    disciplinaBox.remove(disciplinas);
                    anotacaoBox.remove(anotacoes);

                    usuarioLogado.notas.clear();
                    usuarioLogado.setMediaEscolar(7);
                    usuarioLogado.setMediaPessoal(7);
                    usuarioBox.put(usuarioLogado);

                    Toast.makeText(this, "Conta reiniciada", Toast.LENGTH_SHORT).show();

                    onResume();

                }).setNegativeButton("Não", (dilog, i) -> {dilog.dismiss();});
        builder.create().show();
    }

    private void removerConta() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("Deseja mesmo excluir sua conta?")
                .setPositiveButton("Sim", (dialog, i) -> {

                    resetarConta();
                    usuarioBox.remove(usuarioLogado);
                    logout();

                    Toast.makeText(this, "Usuário removido", Toast.LENGTH_SHORT).show();

                }).setNegativeButton("Não", (dilog, i) -> {dilog.dismiss();});
        builder.create().show();

    }

/**    private boolean solicitarSenha() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_solicitacao_de_senha, null);
        EditText editSenha = inflate.findViewById(R.id.edit_solicitar_senha);



        AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("Senha:");
        builder.setView(inflate).setPositiveButton("Ok", (dialog, id) -> {
            try {
                String senha = editSenha.getText().toString();
                ValidadorDeCampos.verificarSenha(editSenha.getText().toString(), usuarioLogado.getSenha());
                retorno = true;
            } catch (SenhaIncorretaException e) {
                Toast.makeText(this, "Senha incorreta!", Toast.LENGTH_SHORT).show();
                solicitarSenha();
            }
        }).setNegativeButton("Cancelar", (dialog, id) -> {
            retorno[0] = false;
            dialog.dismiss();
        }).show();
        return retorno[0];
    }*/

    private void logout() {
        getSharedPreferences("appnotas.file", MODE_PRIVATE).edit().clear().commit();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new DisciplinasFragment(), "Disciplinas");
        adapter.addFragment(new AgendaFragment(), "Agenda");
        viewPager.setAdapter(adapter);
    }

    private boolean logado() {
        final long usuarioId = getSharedPreferences("appnotas.file", MODE_PRIVATE)
                .getLong("usuarioId", -1);
        return (usuarioId != -1);
    }

    private Usuario obterUsuarioLogado() {
        final long usuarioId = getSharedPreferences("appnotas.file", MODE_PRIVATE)
                .getLong("usuarioId", -1);
        return (usuarioId == -1) ? null : usuarioBox.get(usuarioId);
    }
}
