package com.example.micaelleal.projetoboletimescolar.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

/**
 * Created by micaelleal on 04/03/18.
 */

@Entity
public class NotasBimestre {

    @Id
    private long id;
    private int bimestreId;
    private double pontos;
    private double notaMensal;
    private double notaBimestral;
    private double recuperacao;
    public ToOne<Usuario> usuarioDono;

    public NotasBimestre() {
    }

    public NotasBimestre(int bimestreId, Usuario usuario) {
        usuarioDono.setTarget(usuario);
        this.bimestreId = bimestreId;
        this.pontos = 0;
        this.notaMensal = -1;
        this.notaBimestral = -1;
        this.recuperacao = -1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBimestreId() {
        return bimestreId;
    }

    public double getMedia() {
        double media = ((notaBimestral == -1) ? notaMensal : (notaMensal + notaBimestral) / 2) + pontos;
        if (media < usuarioDono.getTarget().getMediaEscolar()) {
            if (recuperacao >= 0 && recuperacao > media) {
                return recuperacao;
            }
        }
        recuperacao = -1;
        return media > 10 ? 10 : media;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        if (pontos > 5) {
            this.pontos = 5;
        } else  if (pontos < 0) {
            this.pontos = 0;
        } else  {
            this.pontos = pontos;
        }
    }

    public double getNotaMensal() {
        return notaMensal;
    }

    public void setNotaMensal(double notaMensal) {
        if (notaMensal > 10) {
            this.notaMensal = 10;
        } else  if (notaMensal < 0) {
            this.notaMensal = 0;
        } else  {
            this.notaMensal = notaMensal;
        }
    }

    public double getNotaBimestral() {
        return notaBimestral;
    }

    public void setNotaBimestral(double notaBimestral) {
        if (notaBimestral > 10) {
            this.notaBimestral = 10;
        } else  if (notaBimestral < 0) {
            this.notaBimestral = 0;
        } else  {
            this.notaBimestral = notaBimestral;
        }
    }

    public double getRecuperacao() {
        return recuperacao;
    }

    public void setRecuperacao(double recuperacao) {
        if (recuperacao > 10) {
            this.recuperacao = 10;
        } else  if (recuperacao < 0) {
            this.recuperacao = 0;
        } else  {
            this.recuperacao = recuperacao;
        }
    }

}
