package com.example.well.TREINAMENTO_API.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public abstract class RestauranteNaoEncontradaException extends NegocioException {

    @Serial
    private static final long serialVersionUID = 1L;

    public RestauranteNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

    public RestauranteNaoEncontradaException(Long restauranteId){
        this(String.format("Não existe um cadastro de restaurante com código %d", restauranteId));
    }
}