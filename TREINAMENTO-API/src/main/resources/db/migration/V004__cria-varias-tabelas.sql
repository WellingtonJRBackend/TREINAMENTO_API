CREATE TABLE restaurante (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    taxa_frente DECIMAL(10,2) NOT NULL,
    cozinha_id BIGINT NOT NULL,
    endereco_cep VARCHAR(9),
    endereco_logradouro VARCHAR(80),
    endereco_numero VARCHAR(20),
    endereco_complemento VARCHAR(80),
    endereco_bairro VARCHAR(80),
    endereco_cidade_id BIGINT,
    data_cadastro TIMESTAMP(0) NOT NULL,
    data_atualizacao TIMESTAMP(0) NOT NULL,
    CONSTRAINT fk_restaurante_cozinha FOREIGN KEY (cozinha_id) REFERENCES cozinha(id),
    CONSTRAINT fk_restaurante_cidade FOREIGN KEY (endereco_cidade_id) REFERENCES cidade(id)
);

CREATE TABLE formas_pagamento (
    id BIGSERIAL PRIMARY KEY,
    descricao VARCHAR(60)
);

CREATE TABLE restaurante_forma_pagamento (
    restaurante_id BIGINT NOT NULL,
    forma_pagamento_id BIGINT NOT NULL,
    PRIMARY KEY (restaurante_id, forma_pagamento_id),
    CONSTRAINT fk_rest_forma_pag_restaurante FOREIGN KEY (restaurante_id) REFERENCES restaurante(id),
    CONSTRAINT fk_rest_forma_pag_forma FOREIGN KEY (forma_pagamento_id) REFERENCES formas_pagamento(id)
);

CREATE TABLE produto (
    id BIGSERIAL PRIMARY KEY,
    descricao VARCHAR(80) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    ativo BOOLEAN,
    restaurante_id BIGINT NOT NULL,
    CONSTRAINT fk_produto_restaurante FOREIGN KEY (restaurante_id) REFERENCES restaurante(id)
);

CREATE TABLE permissao (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(80),
    descricao VARCHAR(80)
);

CREATE TABLE grupo (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(80) NOT NULL
);

CREATE TABLE grupo_permissao (
    grupo_id BIGINT NOT NULL,
    permissao_id BIGINT NOT NULL,
    PRIMARY KEY (grupo_id, permissao_id),
    CONSTRAINT fk_grupo_permissao_grupo FOREIGN KEY (grupo_id) REFERENCES grupo(id),
    CONSTRAINT fk_grupo_permissao_permissao FOREIGN KEY (permissao_id) REFERENCES permissao(id)
);

CREATE TABLE usuario (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(80) NOT NULL,
    email VARCHAR(60) NOT NULL,
    data_cadastro TIMESTAMP NOT NULL
);

CREATE TABLE usuario_grupo (
    usuario_id BIGINT NOT NULL,
    grupo_id BIGINT NOT NULL,
    PRIMARY KEY (usuario_id, grupo_id),
    CONSTRAINT fk_usuario_grupo_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    CONSTRAINT fk_usuario_grupo_grupo FOREIGN KEY (grupo_id) REFERENCES grupo(id)
    );