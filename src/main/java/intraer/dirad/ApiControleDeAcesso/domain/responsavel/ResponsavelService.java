package intraer.dirad.ApiControleDeAcesso.domain.responsavel;

import intraer.dirad.ApiControleDeAcesso.domain.responsavel.validacoes.DadosAtualizacaoResponsavel;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.validacoes.DadosCadastroResponsavel;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.validacoes.DadosResponsavel;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResponsavelService {
    private final ResponsavelRepository repository;
    private final ModelMapper mapper;

    public Page<DadosResponsavel> findAll(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosResponsavel::new);

    }

    public DadosResponsavel salvar(@Valid DadosCadastroResponsavel dados) {
        var responsavel = mapper.map(dados, Responsavel.class);
        repository.save(responsavel);
        return mapper.map(responsavel, DadosResponsavel.class);
    }

    public DadosResponsavel atualizar(UUID id, @Valid DadosAtualizacaoResponsavel dado) {
        var responsavel = mapper.map(dado,Responsavel.class);
        responsavel = repository.save(responsavel);
        return mapper.map(responsavel, DadosResponsavel.class);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public DadosResponsavel findById(UUID id) {
        var responsavel = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("responsavel not found"));
        return mapper.map(responsavel, DadosResponsavel.class);
    }
    
}
