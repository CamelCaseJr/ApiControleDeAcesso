package intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.validacoes.DadosAtualizacaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.validacoes.DadosCadastroGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.validacoes.DadosGerenteLocalAcesso;
import jakarta.validation.Valid;

@Service
@AllArgsConstructor
public class PermissaoGerenteLocalService {
    private final PermGerentLocalRepository repository;
    private final ModelMapper mapper;

    public Page<DadosGerenteLocalAcesso> findAll(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosGerenteLocalAcesso::new);

    }

    public DadosGerenteLocalAcesso findById(UUID id) {
        var gerente = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("gerente não encontrada"));
        return mapper.map(gerente, DadosGerenteLocalAcesso.class);
    }

    public DadosGerenteLocalAcesso salvar(@Valid DadosCadastroGerenteLocalAcesso dados) {
        var gerente = mapper.map(dados, PermissaoGerenteLocalAcesso.class);
        repository.save(gerente);
        return mapper.map(gerente, DadosGerenteLocalAcesso.class);
    }

    public DadosGerenteLocalAcesso atualizar(UUID id, @Valid DadosAtualizacaoGerenteLocalAcesso dado) {
        var gerente = mapper.map(dado, PermissaoGerenteLocalAcesso.class);
        gerente.setId(id);
        gerente = repository.save(gerente);
        return mapper.map(gerente, DadosGerenteLocalAcesso.class);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
    
}
