package com.example.well.TREINAMENTO_API.domain.sevice;

import com.example.well.TREINAMENTO_API.domain.exception.EntidadeEmUsoException;
import com.example.well.TREINAMENTO_API.domain.exception.EntidadeNaoEncontradaException;
import com.example.well.TREINAMENTO_API.domain.model.Cidade;
import com.example.well.TREINAMENTO_API.domain.model.Estado;
import com.example.well.TREINAMENTO_API.domain.repository.CidadeRepository;
import com.example.well.TREINAMENTO_API.domain.repository.EstadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Cidade> listar() {
        return cidadeRepository.findAll();
    }

    public Cidade salvar(Cidade cidade) {
        Long cidadeId = cidade.getEstado().getId();
        Optional<Estado> estado = estadoRepository.findById(cidadeId);

        if (estado.isEmpty()) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe estado cadastrado com o cógido %d", cidadeId));
        }
        cidade.setEstado(estado.get());

        return cidadeRepository.save(cidade);
    }
    @Transactional
    public void excluir(Long cidadeId) {

        Cidade cidade = cidadeRepository.findById(cidadeId).orElseThrow(()
                -> new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cidade com esse código %d", cidadeId)));
        try {
            cidadeRepository.deleteById(cidadeId);
            cidadeRepository.flush();
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
        }
    }
}
