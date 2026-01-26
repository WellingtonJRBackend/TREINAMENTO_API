package com.example.well.TREINAMENTO_API.Infrastructure.Repository;

import com.example.well.TREINAMENTO_API.domain.model.Cozinha;
import com.example.well.TREINAMENTO_API.domain.model.Estado;
import com.example.well.TREINAMENTO_API.domain.repository.EstadoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> listar() {
        return manager.createQuery("From Estado", Estado.class)
                .getResultList();
    }

    @Override
    public Estado buscar(Long id) {
        return manager.find(Estado.class,id);
    }
    @Transactional
    @Override
    public Estado salvar(Estado estado) {
        return manager.merge(estado);
    }

    @Transactional
    @Override
    public void remover(Long estadoIdd) {
        Estado estado = buscar(estadoIdd);

        if (estado ==null){
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(estado);
    }
}
