package com.example.well.TREINAMENTO_API.domain.repository;

import com.example.well.TREINAMENTO_API.domain.model.Restaurante;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository {

    List<Restaurante> listar();
    Restaurante buscarPorId(Long id);
    Restaurante salvar (Restaurante restaurante);
    void remove (Restaurante restaurante);

}
