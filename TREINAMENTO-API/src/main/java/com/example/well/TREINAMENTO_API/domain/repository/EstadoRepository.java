package com.example.well.TREINAMENTO_API.domain.repository;

import com.example.well.TREINAMENTO_API.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Long> {


}
