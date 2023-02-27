package intraer.dirad.ApiControleDeAcesso.domain.secao;

import intraer.dirad.ApiControleDeAcesso.domain.secao.validacoes.DadosAtualizacaoSecao;
import intraer.dirad.ApiControleDeAcesso.domain.secao.validacoes.DadosCadastroSecao;
import intraer.dirad.ApiControleDeAcesso.domain.secao.validacoes.DadosSecao;
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
public class SecaoService {
    private final SecaoRepository repository;
    private final ModelMapper mapper;

    public Page<DadosSecao> findAll(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosSecao::new);
    }

    public DadosSecao salvar(@Valid DadosCadastroSecao dados) {
        var secao = mapper.map(dados, Secao.class);
        repository.save(secao);
        return mapper.map(secao, DadosSecao.class);
    }

    public DadosSecao atualizar(UUID id, @Valid DadosAtualizacaoSecao dado) {
        var secao = mapper.map(dado,Secao.class);
        secao = repository.save(secao);
        return mapper.map(secao, DadosSecao.class);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public DadosSecao findById(UUID id) {
        var secao = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("secao not found"));
        return mapper.map(secao, DadosSecao.class);
    }
    
}
