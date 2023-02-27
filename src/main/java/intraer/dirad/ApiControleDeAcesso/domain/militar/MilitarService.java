package intraer.dirad.ApiControleDeAcesso.domain.militar;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosAtualizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosMilitar;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class MilitarService {
    private final MilitarRepository repository;
    private final ModelMapper mapper;

    public Page<DadosMilitar> findAll(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosMilitar::new);
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
        var militar = mapper.map(dado, Militar.class);
        militar = repository.save(militar);
        return mapper.map(militar, DadosMilitar.class);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
    
}
