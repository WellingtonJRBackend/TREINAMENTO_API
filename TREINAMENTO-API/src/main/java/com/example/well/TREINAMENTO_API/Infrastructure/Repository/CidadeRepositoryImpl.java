package com.example.well.TREINAMENTO_API.Infrastructure.Repository;

import com.example.well.TREINAMENTO_API.domain.model.Cidade;
import com.example.well.TREINAMENTO_API.domain.model.Cozinha;
import com.example.well.TREINAMENTO_API.domain.repository.CidadeRepository;
import com.example.well.TREINAMENTO_API.domain.repository.CozinhaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CidadeRepositoryImpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cidade> listar() {
        return manager.createQuery("From Cidade ", Cidade.class)
                .getResultList();
    }

    @Override
    public Cidade buscar(Long id) {
        return manager.find(Cidade.class, id);
    }

    @Transactional
    @Override
    public Cidade salvar(Cidade cidade) {
        return manager.merge(cidade);
    }

    @Transactional
    @Override
    public void remover(Long id) {
       Cidade cidade = buscar(id);

       if (cidade ==null){
           throw new EmptyResultDataAccessException(1);
       }
        manager.remove(cidade);
    }


}
