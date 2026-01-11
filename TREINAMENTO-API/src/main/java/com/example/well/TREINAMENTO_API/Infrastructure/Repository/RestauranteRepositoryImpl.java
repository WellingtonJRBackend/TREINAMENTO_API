package com.example.well.TREINAMENTO_API.Infrastructure.Repository;

import com.example.well.TREINAMENTO_API.domain.model.Restaurante;
import com.example.well.TREINAMENTO_API.domain.repository.RestauranteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> listar() {
        return manager.createQuery("From Restaurante", Restaurante.class)
                .getResultList();
    }

    @Override
    public Restaurante buscarPorId(Long id) {
        return manager.find(Restaurante.class,id);
    }
    @Transactional
    @Override
    public Restaurante salvar(Restaurante restaurante) {
        return manager.merge(restaurante);
    }

    @Override
    public void remove(Restaurante restaurante) {
    restaurante = buscarPorId(restaurante.getId());
    manager.remove(restaurante);
    }
}
