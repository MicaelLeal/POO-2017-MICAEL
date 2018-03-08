package com.example.micaelleal.projetoboletimescolar.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.micaelleal.projetoboletimescolar.R;
import com.example.micaelleal.projetoboletimescolar.adapters.AnotacoesRvAdapter;
import com.example.micaelleal.projetoboletimescolar.dal.App;
import com.example.micaelleal.projetoboletimescolar.model.Anotacao;
import com.example.micaelleal.projetoboletimescolar.model.Anotacao_;
import com.example.micaelleal.projetoboletimescolar.model.Usuario;

import java.util.List;

import io.objectbox.Box;

/**
 * Created by micaelleal on 02/03/18.
 */

public class AgendaFragment extends Fragment {

    private static View view;
    private RecyclerView rvAgenda;
    private AnotacoesRvAdapter adapter;
    private Box<Anotacao> anotacaoBox;
    private Box<Usuario> usuarioBox;
    private Usuario usuarioLogado;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_agenda_layout, container, false);

        usuarioBox = ((App) getActivity().getApplication()).getBoxStore().boxFor(Usuario.class);
        anotacaoBox = ((App) getActivity().getApplication()).getBoxStore().boxFor(Anotacao.class);
        usuarioLogado = obterUsuarioLogado();

        setupViews();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        List<Anotacao> anotacoes = anotacaoBox.query()
                .equal(Anotacao_.usuarioDonoId, usuarioLogado.getId())
                .build().find();

        adapter = new AnotacoesRvAdapter(getActivity(), anotacaoBox, anotacoes);
        rvAgenda.setAdapter(adapter);
        rvAgenda.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAgenda.setHasFixedSize(true);

    }

    private void setupViews() {
        rvAgenda = view.findViewById(R.id.rv_anotacoes);
    }

    private Usuario obterUsuarioLogado() {
        final SharedPreferences preferences = getActivity().getSharedPreferences("appnotas.file", Context.MODE_PRIVATE);
        final long usuarioId = preferences.getLong("usuarioId", -1);
        return usuarioBox.get(usuarioId);
    }
}
