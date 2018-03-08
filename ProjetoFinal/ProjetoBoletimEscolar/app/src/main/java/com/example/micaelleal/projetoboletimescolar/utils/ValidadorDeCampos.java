package com.example.micaelleal.projetoboletimescolar.utils;

import android.util.Patterns;

import com.example.micaelleal.projetoboletimescolar.exceptions.ConfirmacaoSenhaIncorretaException;
import com.example.micaelleal.projetoboletimescolar.exceptions.EmailInvalidoException;
import com.example.micaelleal.projetoboletimescolar.exceptions.SenhaIncorretaException;
import com.example.micaelleal.projetoboletimescolar.exceptions.StringVaziaException;
import com.example.micaelleal.projetoboletimescolar.exceptions.UsuarioExistenteException;
import com.example.micaelleal.projetoboletimescolar.model.Usuario;

import java.util.List;

/**
 * Created by micaelleal on 04/03/18.
 */

public class ValidadorDeCampos {

    public ValidadorDeCampos() {    }

    public static void validarString(String str1) {
        if (str1.trim().isEmpty()) throw new StringVaziaException();
    }

    public static void validarString(String str1, String str2) {
        validarString(str1);
        validarString(str2);
    }

    public static void validarString(String str1, String str2, String str3) {
        validarString(str1, str2);
        validarString(str3);
    }

    public static void validarEmail(String email) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            throw new EmailInvalidoException();
        }
    }

    public static void validarConfirmacaoDeSenha(String senha, String senhaConfirm) {
        if (!senha.equals(senhaConfirm)) {
            throw new ConfirmacaoSenhaIncorretaException();
        }
    }

    public static void verificarSeExixtente(List<Usuario> usuarios, String email) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getEmail().equals(email)) {
                throw new UsuarioExistenteException();
            }
        }
    }

    public static void verificarSenha(String senha, String senhaPassada) {
        if (!senha.equals(senhaPassada)) {
            throw new SenhaIncorretaException();
        }
    }

}
