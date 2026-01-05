package com.example.well.TREINAMENTO_API.domain.Repository;

import com.example.well.TREINAMENTO_API.domain.Model.Restaurante;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository {

    List<Restaurante> listar();
    Restaurante buscarPorId(Long id);
    Restaurante salvar (Restaurante restaurante);
    void remove (Restaurante restaurante);

}
