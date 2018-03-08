package com.example.micaelleal.projetoboletimescolar.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToMany;

/**
 * Created by micaelleal on 26/02/18.
 */

@Entity
public class Usuario {

    @Id private long id;
    private String email;
    private String senha;
    private String nome;
    private String escola;
    private double mediaEscolar;
    private double mediaPessoal;
    public ToMany<NotasBimestre> notas;

    public Usuario() {
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.mediaEscolar = 7;
        this.mediaPessoal = 7;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public double getMediaEscolar() {
        return mediaEscolar;
    }

    public void setMediaEscolar(double mediaEscolar) {
        this.mediaEscolar = mediaEscolar;
    }

    public double getMediaPessoal() {
        return mediaPessoal;
    }

    public void setMediaPessoal(double mediaPessoal) {
        this.mediaPessoal = mediaPessoal;
    }
}
