package intraer.dirad.ApiControleDeAcesso.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import intraer.dirad.ApiControleDeAcesso.models.Gerente;
import intraer.dirad.ApiControleDeAcesso.models.PermissaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.repository.PermGerentLocalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPermissaoGerenteLocalAcesso.DadosAtualizacaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPermissaoGerenteLocalAcesso.DadosCadastroGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPermissaoGerenteLocalAcesso.DadosGerenteLocalAcesso;
import jakarta.validation.Valid;

@Service
@AllArgsConstructor
public class PermissaoGerenteLocalService {
    private final PermGerentLocalRepository repository;
    private final ModelMapper mapper;

    public List<DadosGerenteLocalAcesso> findAll() {
        var gerente = repository.findAll();
        return gerente.stream()
                .map(g-> mapper.map(g, DadosGerenteLocalAcesso.class))
                .collect(Collectors.toList());
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
