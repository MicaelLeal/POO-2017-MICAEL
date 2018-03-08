package com.example.micaelleal.projetoboletimescolar.model;

import android.support.annotation.NonNull;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

/**
 * Created by micaelleal on 18/02/18.
 */

@Entity
public class Disciplina implements Comparable<Disciplina> {

    @Id private long id;
    private String nome;
    private String professor;
    private ToOne<Usuario> usuarioDono;
    private double recuperacaoFinal;
    public ToMany<NotasBimestre> notasAnoLetivo;


    public Disciplina() {
        this.recuperacaoFinal = -1;
    }

    public Disciplina(String nome, String professor) {
        this.nome = nome;
        this.professor = professor;
        this.recuperacaoFinal = -1;
    }

    @Override
    public int compareTo(@NonNull Disciplina disciplina) {
        return getNome().compareToIgnoreCase(disciplina.getNome());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public ToOne<Usuario> getUsuarioDono() {
        return usuarioDono;
    }

    public void setUsuarioDono(ToOne<Usuario> usuarioDono) {
        this.usuarioDono = usuarioDono;
    }

    public double getMediaFinal() {
        double media = 0;
        for (int i = 0; i< 4; i++) {
            if (notasAnoLetivo.get(i).getMedia() == -1) {
                return -1;
            }
            media += notasAnoLetivo.get(i).getMedia();
        }
        media = media/4;

        if (media >= usuarioDono.getTarget().getMediaEscolar()) {
            recuperacaoFinal = -1;
        }

        if (recuperacaoFinal >= 0) {
            if (recuperacaoFinal > media) {
                media = recuperacaoFinal;
            }
        }

        return media;
    }

    public double getRecuperacaoFinal() {
        return recuperacaoFinal;
    }

    public void setRecuperacaoFinal(double recuperacaoFinal) {
        if (recuperacaoFinal > 10) {
            this.recuperacaoFinal = 10;
        } else  if (recuperacaoFinal < 0) {
            this.recuperacaoFinal = 0;
        } else  {
            this.recuperacaoFinal = recuperacaoFinal;
        }
    }
}
