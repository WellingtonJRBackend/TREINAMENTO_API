package com.example.well.TREINAMENTO_API.domain.repository;

import com.example.well.TREINAMENTO_API.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository  extends JpaRepository<Restaurante, Long> {


    @Query("select r from Restaurante r join fetch r.cozinha c left join fetch r.formasPagamento")
    List<Restaurante> findAll();


}
