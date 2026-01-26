package com.example.well.TREINAMENTO_API.domain.repository;

import com.example.well.TREINAMENTO_API.domain.model.Cidade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository {

    List<Cidade> listar();

    Cidade buscar(Long cidadeId);

    Cidade salvar(Cidade cidade);

    void remover(Long id);

}
