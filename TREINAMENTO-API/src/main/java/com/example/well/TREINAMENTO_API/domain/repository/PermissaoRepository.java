package com.example.well.TREINAMENTO_API.domain.repository;

import com.example.well.TREINAMENTO_API.domain.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository  extends JpaRepository<Permissao,Long> {
}
