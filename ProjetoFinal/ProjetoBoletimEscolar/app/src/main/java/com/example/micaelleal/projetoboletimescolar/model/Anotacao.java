package com.example.micaelleal.projetoboletimescolar.model;

import android.support.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

/**
 * Created by micaelleal on 02/03/18.
 */

@Entity
public class Anotacao implements Comparable<Anotacao> {

    @Id private long id;
    private ToOne<Usuario> usuarioDono;
    private String titulo;
    private String data;
    private String conteudo;

    public Anotacao() {
    }

    public Anotacao(String titulo, String data) {
        this.titulo = titulo;
        this.data = data;
    }

    @Override
    public int compareTo(@NonNull Anotacao anotacao) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd - MMMM - yyyy");
            Date date = format.parse(data);
            return date.compareTo(format.parse(anotacao.getData()));
        } catch (ParseException e) {
            return 0;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public ToOne<Usuario> getUsuarioDono() {
        return usuarioDono;
    }

    public void setUsuarioDono(ToOne<Usuario> usuarioDono) {
        this.usuarioDono = usuarioDono;
    }
}
