package com.alura.adopet.utils;

import com.alura.adopet.exception.DadosInvalidoException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidaDados {

    public void validaEmail(String email) throws DadosInvalidoException {
        String emailRegex = "^[\\w\\.-]+@[\\w\\.-]+\\.[a-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()) {
            throw new DadosInvalidoException("Email invalido");
        }
    }

    public void validaSenha(String senha) throws DadosInvalidoException {
        if(senha.isEmpty() || senha.isBlank()) {
            throw new DadosInvalidoException("Senha invalida!");
        }
    }

    public void validaNome(String nome) throws DadosInvalidoException {
        if(nome.isBlank() || nome.isEmpty()) {
            throw new DadosInvalidoException("Nome invalido!");
        }
    }
}
