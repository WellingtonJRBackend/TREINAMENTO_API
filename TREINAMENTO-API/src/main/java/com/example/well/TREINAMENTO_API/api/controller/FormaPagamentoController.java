package com.example.well.TREINAMENTO_API.api.controller;

import com.example.well.TREINAMENTO_API.domain.model.FormasPagamento;
import com.example.well.TREINAMENTO_API.domain.repository.FormaDePagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formasPagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaDePagamentoRepository formaDePagamentoRepository;

    @PostMapping
    public ResponseEntity<FormasPagamento> adicionar(@RequestBody FormasPagamento formasPagamento) {
        FormasPagamento formasPagamentoSalva = formaDePagamentoRepository.save(formasPagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(formasPagamentoSalva);
    }

    @GetMapping
   public ResponseEntity<List<FormasPagamento>> listar(){
        return ResponseEntity.ok().body(formaDePagamentoRepository.findAll());
    }
}
