package intraer.dirad.ApiControleDeAcesso.domain.colaborador;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import intraer.dirad.ApiControleDeAcesso.domain.RepositorioGlobal;
import intraer.dirad.ApiControleDeAcesso.domain.colaborador.ColaboradorRepository;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.domain.colaborador.validacoes.DadosAtualizacaoColaborador;
import intraer.dirad.ApiControleDeAcesso.domain.colaborador.validacoes.DadosCadastroColaborador;
import intraer.dirad.ApiControleDeAcesso.domain.colaborador.validacoes.DadosColaborador;
import intraer.dirad.ApiControleDeAcesso.domain.colaborador.Colaborador;
import jakarta.validation.Valid;

@Service
@AllArgsConstructor
public class ColaboradorService {
    private final RepositorioGlobal repository;
    private final ModelMapper mapper;

    public Page<DadosColaborador> findAll(Pageable pageable) {
        return  repository.getColaboradorRepository().findAll(pageable).map(DadosColaborador::new);
    }

    public DadosColaborador salvar(@Valid DadosCadastroColaborador dado) {
        var colaborador = mapper.map(dado, Colaborador.class);
        var pessoa = mapper.map(dado.getPessoa(), Pessoa.class);
        pessoa = repository.getPessoaRepository().save(pessoa);
        colaborador.setPessoa(pessoa);
        repository.getColaboradorRepository().save(colaborador);

        var salvo= mapper.map(colaborador, DadosColaborador.class);
        return salvo;

    }

    public DadosColaborador getReferenceById(UUID id) {
        return null;
    }

    public DadosColaborador atualizar(UUID id, @Valid DadosAtualizacaoColaborador dado) {

        Colaborador colaborador = mapper.map(dado,Colaborador.class);
        colaborador.setId(id);
        colaborador = repository.getColaboradorRepository().save(colaborador);
        return mapper.map(colaborador, DadosColaborador.class);


    }

    public void delete(UUID id) {
        repository.getColaboradorRepository().deleteById(id);
    }

    public DadosColaborador findById(UUID id) {
        var colaboradorOpitinal = repository.getColaboradorRepository().findById(id);
        Colaborador entity = colaboradorOpitinal
                .orElseThrow(() -> new EntityNotFoundException("People not found"));
        return mapper.map(entity, DadosColaborador.class);
    }

}
