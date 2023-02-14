package intraer.dirad.ApiControleDeAcesso.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import intraer.dirad.ApiControleDeAcesso.models.Dependente;
import intraer.dirad.ApiControleDeAcesso.repository.DependenteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDependente.DadosCadastroDependente;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDependente.DadosDeAtualizacaoDependente;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDependente.DadosDependente;
import jakarta.validation.Valid;

@Service
@AllArgsConstructor
public class DependenteService {
    private final DependenteRepository repository;
    private final ModelMapper mapper;

    public List<DadosDependente> findAll() {
        var dependentes = repository.findAll();
        return dependentes.stream()
                .map(d-> mapper.map(d, DadosDependente.class))
                .collect(Collectors.toList());
    }

    public DadosDependente findById(UUID id) {
        Dependente dependente = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("dependente not found"));
        return mapper.map(dependente, DadosDependente.class);
    }

    public DadosDependente salvar(@Valid DadosCadastroDependente dados) {
        try {
            Dependente dependente = mapper.map(dados, Dependente.class);
            repository.save(dependente);
            return mapper.map(dependente, DadosDependente.class);
        }catch (EntityNotFoundException err){
            throw new EntityNotFoundException(err.getMessage());
        }
    }
    
    public DadosDependente atualizar(UUID id, @Valid DadosDeAtualizacaoDependente dado) {
        Dependente dependente = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("dependente not found"));
        mapper.map(dado,dependente);
        repository.save(dependente);
        return mapper.map(dependente, DadosDependente.class);
    }

    public void delete(UUID id) {
        Dependente dependente = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("dependente not found"));
        repository.delete(dependente);
    }
    
}
