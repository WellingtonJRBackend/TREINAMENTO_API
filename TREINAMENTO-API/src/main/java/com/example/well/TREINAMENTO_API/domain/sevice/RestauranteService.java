package com.example.well.TREINAMENTO_API.domain.sevice;

import com.example.well.TREINAMENTO_API.domain.exception.EntidadeNaoEncontradaException;
import com.example.well.TREINAMENTO_API.domain.model.Cozinha;
import com.example.well.TREINAMENTO_API.domain.model.Restaurante;
import com.example.well.TREINAMENTO_API.domain.repository.CozinhaRepository;
import com.example.well.TREINAMENTO_API.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        if (restaurante.getCozinha() != null) {
            Cozinha cozinha = cozinhaRepository.findById(restaurante.getCozinha().getId())
                    .orElseThrow(() -> new EntidadeNaoEncontradaException(
                            "Cozinha não encontrada"));

            restaurante.setCozinha(cozinha);
        }

        return restauranteRepository.save(restaurante);
    }

}
