package intraer.dirad.ApiControleDeAcesso.domain.dependente;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import intraer.dirad.ApiControleDeAcesso.domain.dependente.Dependente;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.DependenteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes.DadosCadastroDependente;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes.DadosDeAtualizacaoDependente;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes.DadosDependente;
import jakarta.validation.Valid;

@Service
@AllArgsConstructor
public class DependenteService {
    private final DependenteRepository repository;
    private final ModelMapper mapper;

    public List<DadosDependente> findAll() {
        var dependentes = repository.findAll();
        return dependentes.stream()
                .map(d -> mapper.map(d, DadosDependente.class))
                .collect(Collectors.toList());
    }

    public DadosDependente findById(UUID id) {
        Dependente dependente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("dependente not found"));
        return mapper.map(dependente, DadosDependente.class);
    }

    public DadosDependente salvar(@Valid DadosCadastroDependente dados) {

        Dependente dependente = mapper.map(dados, Dependente.class);
        dependente = repository.save(dependente);
        return mapper.map(dependente, DadosDependente.class);
    }

    public DadosDependente atualizar(UUID id, @Valid DadosDeAtualizacaoDependente dado) {
        var dependente = mapper.map(dado, Dependente.class);
        dependente.setId(id);
        dependente = repository.save(dependente);
        return mapper.map(dependente, DadosDependente.class);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

}
