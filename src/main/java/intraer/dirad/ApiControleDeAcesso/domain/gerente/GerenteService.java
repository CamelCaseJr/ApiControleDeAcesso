package intraer.dirad.ApiControleDeAcesso.domain.gerente;

import intraer.dirad.ApiControleDeAcesso.domain.gerente.validacoes.DadosCadastroGerente;
import intraer.dirad.ApiControleDeAcesso.domain.gerente.validacoes.DadosGerente;
import intraer.dirad.ApiControleDeAcesso.domain.gerente.Gerente;
import intraer.dirad.ApiControleDeAcesso.domain.gerente.GerenteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GerenteService {
    private final GerenteRepository repository;
    private final ModelMapper mapper;

    public List<DadosGerente>findAll() {
        var gerentes = repository.findAll();
        return gerentes.stream()
                .map(c-> mapper.map(c, DadosGerente.class))
                .collect(Collectors.toList());
    }

    public DadosGerente salvar(@Valid DadosCadastroGerente dados) {
        var gerente = mapper.map(dados, Gerente.class);
        repository.save(gerente);
        return mapper.map(gerente, DadosGerente.class);
    }

    public DadosGerente atualizar(UUID id, @Valid DadosCadastroGerente dado) {
        var gerente = mapper.map(dado,Gerente.class);
        gerente = repository.save(gerente);
        return mapper.map(gerente, DadosGerente.class);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public DadosGerente findById(UUID id) {
        var gerente = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("gerente not found"));
        return mapper.map(gerente, DadosGerente.class);
    }
    
}
