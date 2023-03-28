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
}
