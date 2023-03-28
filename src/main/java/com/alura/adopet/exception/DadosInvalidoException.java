package com.alura.adopet.exception;

public class DadosInvalidoException extends Exception{

    public DadosInvalidoException(String message) {
        super(message);
    }

    public DadosInvalidoException() {
        super("Dados inválidos.");
    }
}
