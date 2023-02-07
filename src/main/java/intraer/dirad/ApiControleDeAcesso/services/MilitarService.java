package intraer.dirad.ApiControleDeAcesso.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar.DadosAtualizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar.DadosMilitar;
import intraer.dirad.ApiControleDeAcesso.models.Militar;
import intraer.dirad.ApiControleDeAcesso.repository.MilitarRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class MilitarService {
    private final MilitarRepository repository;
    private final ModelMapper mapper;

    public List<DadosMilitar> findAll() {
        var militar = repository.findAll();
        return militar.stream()
        .map(m-> mapper.map(m, DadosMilitar.class))
        .collect(Collectors.toList());
    }

    public DadosMilitar findById(UUID id) {
        Militar militar = repository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("Militar não encontrado"));
        return mapper.map(militar, DadosMilitar.class);
    }

    public DadosMilitar salvar(@Valid DadosCadastroMilitar dados) {
        var militar = mapper.map(dados, Militar.class);
        repository.save(militar);
        return mapper.map(militar, DadosMilitar.class);
    }

    public DadosMilitar atualizar(UUID id, @Valid DadosAtualizacaoMilitar dado) {
        Militar militar = repository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("militar não encontrado"));
        mapper.map(dado, militar);
        repository.save(militar);
        return mapper.map(militar, DadosMilitar.class);
    }

    public void delete(UUID id) {
    }
    
}
