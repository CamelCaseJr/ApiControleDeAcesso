package intraer.dirad.ApiControleDeAcesso.domain.dependente;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<DadosDependente> findAll(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosDependente::new);

    }

    public DadosDependente findById(UUID id) {
        Dependente dependente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("dependente not found"));
        return mapper.map(dependente, DadosDependente.class);
    }

    public DadosDependente salvar(@Valid DadosCadastroDependente dados) {

        Dependente dependente = mapper.map(dados, Dependente.class);

        verificaSeODependenteExiste(dependente);

        dependente = repository.save(dependente);
        return mapper.map(dependente, DadosDependente.class);
    }

    public DadosDependente findByNome(String nome){
       var dependente = repository.findByPessoaNome(nome)
               .orElseThrow(() -> new EntityNotFoundException("dependente not found"));
       return new DadosDependente(dependente);
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


    private void verificaSeODependenteExiste(Dependente dependente) {
        repository.findByPessoaNome(dependente.getPessoa().getNome())
                .orElseThrow(()-> new EntityExistsException("Dependente já existe."));
    }
}
