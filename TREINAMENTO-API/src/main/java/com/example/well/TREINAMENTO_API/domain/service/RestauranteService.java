package com.example.well.TREINAMENTO_API.domain.service;

import com.example.well.TREINAMENTO_API.domain.exception.CozinhaNaoEncontradaException;
import com.example.well.TREINAMENTO_API.domain.exception.EntidadeNaoEncontradaException;
import com.example.well.TREINAMENTO_API.domain.exception.RestauranteNaoEncontradaException;
import com.example.well.TREINAMENTO_API.domain.model.Cozinha;
import com.example.well.TREINAMENTO_API.domain.model.Restaurante;
import com.example.well.TREINAMENTO_API.domain.repository.CozinhaRepository;
import com.example.well.TREINAMENTO_API.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        if (restaurante.getCozinha() != null) {
            Long cozinhaId = restaurante.getCozinha().getId();
            Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
                            .orElseThrow(()-> new CozinhaNaoEncontradaException(cozinhaId));

            restaurante.setCozinha(cozinha);
        }

        return restauranteRepository.save(restaurante);
    }

}
