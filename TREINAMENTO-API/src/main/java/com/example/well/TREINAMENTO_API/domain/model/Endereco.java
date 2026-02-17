package com.example.well.TREINAMENTO_API.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class Endereco {

    @Column(name = "endereco_cep")
    private String ceep;

    @Column(name = "endereco_logradouro")
    private String logradouro;

    @Column(name = "endereco_numero")
    private String numero;

    @Column(name = "endereco_complemento")
    private String complemento;

    @Column(name = "endereco_bairro")
    private String bairro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_cidade_id")
    private Cidade cidade;
}
