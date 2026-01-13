package com.example.well.TREINAMENTO_API.domain.exception;

import java.io.Serial;

public class EntidadeEmUsoException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public EntidadeEmUsoException (String mensagem){
        super(mensagem);
    }
}
