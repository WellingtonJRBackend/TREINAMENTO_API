package com.example.well.TREINAMENTO_API.api.controller;

import com.example.well.TREINAMENTO_API.domain.model.Restaurante;
import com.example.well.TREINAMENTO_API.domain.repository.RestauranteRepository;
import com.example.well.TREINAMENTO_API.domain.sevice.RestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteRepository.listar();
    }

    @GetMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> buscar (@PathVariable Long restauranteId){

        Restaurante restaurante = restauranteRepository.buscarPorId(restauranteId);

        if (restaurante != null){
            return ResponseEntity.ok(restaurante);
        }
        return ResponseEntity.notFound().build();
    }
}
