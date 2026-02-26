CREATE TABLE pedido (
    id BIGSERIAL PRIMARY KEY,
    taxa_frete DECIMAL(10,2) NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL,
    data_criacao TIMESTAMP  NOT NULL,
    data_confirmacao TIMESTAMP  NOT NULL,
    data_cancelamento TIMESTAMP ,
    data_entrega TIMESTAMP  NOT NULL,
    restaurante_id BIGINT NOT NULL,
    endereco_cep VARCHAR(9),
    endereco_logradouro VARCHAR(80),
    endereco_numero VARCHAR(20),
    endereco_complemento VARCHAR(80),
    endereco_bairro VARCHAR(100),
    endereco_cidade_id BIGINT,
    cliente_id BIGINT NOT NULL,
    forma_pagamento_id BIGINT NOT NULL,
    status VARCHAR(20) NOT NULL,
    CONSTRAINT fk_pedido_restaurante FOREIGN KEY (restaurante_id) REFERENCES restaurante(id),
    CONSTRAINT fk_pedido_cidade FOREIGN KEY (endereco_cidade_id) REFERENCES cidade(id),
    CONSTRAINT fk_pedido_cliente FOREIGN KEY (cliente_id) REFERENCES usuario(id),
    CONSTRAINT fk_pedido_forma_pagamento FOREIGN KEY (forma_pagamento_id) REFERENCES formas_pagamento(id)
);

CREATE TABLE item_pedido (
    id BIGSERIAL PRIMARY KEY,
    quantidade INTEGER NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    preco_total DECIMAL(10,2) NOT NULL,
    observacao VARCHAR(255),
    pedido_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,
    CONSTRAINT fk_item_pedido_pedido FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    CONSTRAINT fk_item_pedido_produto FOREIGN KEY (produto_id) REFERENCES produto(id)
);