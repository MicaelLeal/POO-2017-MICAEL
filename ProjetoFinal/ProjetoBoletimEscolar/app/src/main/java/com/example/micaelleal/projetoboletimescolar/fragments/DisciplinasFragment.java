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
import com.example.micaelleal.projetoboletimescolar.adapters.DisciplinasRvAdapter;
import com.example.micaelleal.projetoboletimescolar.dal.App;
import com.example.micaelleal.projetoboletimescolar.model.Disciplina;
import com.example.micaelleal.projetoboletimescolar.model.Disciplina_;
import com.example.micaelleal.projetoboletimescolar.model.Usuario;


import java.util.List;

import io.objectbox.Box;

/**
 * Created by micaelleal on 18/02/18.
 */

public class DisciplinasFragment extends Fragment {
    private static View view;
    private RecyclerView rvDisciplinas;
    private DisciplinasRvAdapter adapter;
    private Box<Disciplina> disciplinaBox;
    private Box<Usuario> usuarioBox;
    private Usuario usuarioLogado;

    public DisciplinasFragment() {    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_disciplinas_layout, container, false);

        disciplinaBox = ((App) getActivity().getApplication()).getBoxStore().boxFor(Disciplina.class);
        usuarioBox = ((App) getActivity().getApplication()).getBoxStore().boxFor(Usuario.class);
        usuarioLogado = obterUsuarioLogado();

        setupViews();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        List<Disciplina> disciplinas = disciplinaBox.query()
                .equal(Disciplina_.usuarioDonoId, usuarioLogado.getId())
                .build()
                .find();

        adapter = new DisciplinasRvAdapter(getActivity(), disciplinaBox, disciplinas);
        rvDisciplinas.setAdapter(adapter);
        rvDisciplinas.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvDisciplinas.setHasFixedSize(true);
    }

    private void setupViews() {
        rvDisciplinas = view.findViewById(R.id.rv_disciplinas);
    }

    private Usuario obterUsuarioLogado() {
        final SharedPreferences preferences = getActivity().getSharedPreferences("appnotas.file", Context.MODE_PRIVATE);
        final long usuarioId = preferences.getLong("usuarioId", -1);
        return usuarioBox.get(usuarioId);
    }

}
