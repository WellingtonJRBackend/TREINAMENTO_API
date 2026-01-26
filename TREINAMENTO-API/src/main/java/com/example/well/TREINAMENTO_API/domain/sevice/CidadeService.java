package com.example.well.TREINAMENTO_API.domain.sevice;

import com.example.well.TREINAMENTO_API.domain.exception.EntidadeEmUsoException;
import com.example.well.TREINAMENTO_API.domain.exception.EntidadeNaoEncontradaException;
import com.example.well.TREINAMENTO_API.domain.model.Cidade;
import com.example.well.TREINAMENTO_API.domain.model.Estado;
import com.example.well.TREINAMENTO_API.domain.repository.CidadeRepository;
import com.example.well.TREINAMENTO_API.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Cidade> listar() {
        return cidadeRepository.listar();
    }

    public Cidade salvar(Cidade cidade) {
        Long cidadeId = cidade.getEstado().getId();
        Estado estado = estadoRepository.buscar(cidadeId);

        if (estado == null) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe estado cadastrado com o cógido %d", cidadeId));
        }
        cidade.setEstado(estado);

        return cidadeRepository.salvar(cidade);
    }

    public void excluir(Long cidadeId) {
        try {
            cidadeRepository.remover(cidadeId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cidade com esse código %d", cidadeId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
        }
    }
}
