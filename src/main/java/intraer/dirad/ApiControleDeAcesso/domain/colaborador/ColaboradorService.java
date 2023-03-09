package intraer.dirad.ApiControleDeAcesso.domain.colaborador;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import intraer.dirad.ApiControleDeAcesso.domain.RepositorioGlobal;
import intraer.dirad.ApiControleDeAcesso.domain.colaborador.ColaboradorRepository;
import intraer.dirad.ApiControleDeAcesso.domain.efetivo.Efetivo;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.Empresa;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import jakarta.persistence.EntityExistsException;
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
        var pessoa = mapper.map(dado.getPessoa(), Pessoa.class);
        var empresa = mapper.map(dado.getEmpresa(), Empresa.class);
        var colaborador = repository.getColaboradorRepository()
                .findByPessoaCpf(pessoa.getCpf())
                .orElseGet(Colaborador::new);

        verificaSeEMilitar(pessoa);
        verificaSeJaPertenceAoEfetivo(pessoa);

        if(colaborador.getPessoa() == null) {
            pessoa = getPessoa(pessoa);
            empresa = getEmpresa(empresa);


            colaborador.setPessoa(pessoa);
            colaborador.setEmpresa(empresa);
            colaborador = repository.getColaboradorRepository().save(colaborador);
        }

        return new DadosColaborador(colaborador);

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

    public DadosColaborador findByCpf(String cpf){
        Optional<Colaborador> optionalColaborador = repository.getColaboradorRepository().findByPessoaCpf(cpf);
        Colaborador colaborador = optionalColaborador.orElseThrow(() -> new EntityNotFoundException("People not found"));
        return new DadosColaborador(colaborador);

    }


    private Empresa getEmpresa(Empresa empresa) {
        return repository.getEmpresaRepository()
                .findByNome(empresa.getNome()).orElseGet(() -> repository.getEmpresaRepository().save(empresa));
    }

    private Pessoa getPessoa(Pessoa pessoa) {
        return repository.getPessoaRepository()
                .findByCpf(pessoa.getCpf())
                .orElseGet(() -> repository.getPessoaRepository().save(pessoa));
    }

    private void verificaSeEMilitar(Pessoa pessoa) {
        var isMilitar = repository.getMilitarRepository()
                .findByPessoaCpf(pessoa.getCpf())
                .isPresent();
        if (isMilitar)throw new EntityExistsException("Esta pessoa é militar");
    }

    private void verificaSeJaPertenceAoEfetivo(Pessoa pessoa) {
        var optionalEfetivo = repository.getEfetivoRepository().findByPessoaNome(pessoa.getNome());
        if (optionalEfetivo.isPresent()) throw new EntityNotFoundException("Esta pessoa já pertence ao efetivo da "
                + optionalEfetivo.get().getOrganizacaoMilitar().getNome());
    }
}
