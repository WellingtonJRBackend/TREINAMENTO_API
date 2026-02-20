create table estado(
 id bigserial primary key,
 nome varchar (80)
 );

insert into estado (nome) select distinct nome_estado from cidade;

alter table cidade add column estado_id bigserial not null;

update cidade c set estado_id = (select e.id from estado e where e.nome = c.nome_estado);

alter table cidade add constraint fk_cidade_estado foreign key (estado_id) references estado(id);

alter table cidade drop column nome_estado;

ALTER TABLE cidade RENAME COLUMN nome_cidade TO nome;