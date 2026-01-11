package com.example.well.TREINAMENTO_API.domain.repository;

import com.example.well.TREINAMENTO_API.domain.model.Estado;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository {

     List<Estado> listar();

     Estado buscar (Long id);

     Estado salvar (Estado estado);

     void remover (Estado estado);

}
