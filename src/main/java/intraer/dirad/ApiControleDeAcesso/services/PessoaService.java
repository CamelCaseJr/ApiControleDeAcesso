package intraer.dirad.ApiControleDeAcesso.services;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosCadastroContato;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDependente.DadosDependente;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosPessoa;
import intraer.dirad.ApiControleDeAcesso.facade.PessoaFacade;
import intraer.dirad.ApiControleDeAcesso.models.Contato;
import intraer.dirad.ApiControleDeAcesso.models.Militar;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.repository.RepositorioGlobal;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PessoaService {

    private final RepositorioGlobal repository;
    private final ModelMapper mapper;
    private final PessoaFacade pessoaFacade;




    public List<DadosPessoa> findAll() {
        var pessoa = repository.getPessoaRepository().findAll();
        return DadosPessoa.toDadosPesso(pessoa);
    }

    public DadosPessoa findById(UUID id) {
        var pessoa = getPessoaPorId(id);
        return mapper.map(pessoa, DadosPessoa.class);
    }

    public DadosPessoa findByNome(String nome) {
        var pessoa = repository.getPessoaRepository().findByNome(nome)
                .orElseThrow(() -> new EntityNotFoundException("pessoa não encontrada"));
        return mapper.map(nome, DadosPessoa.class);
    }

    public DadosPessoa findByCpf(String cpf) {
        var pessoa = repository.getPessoaRepository().findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException("cpf não encontrada"));
        return mapper.map(cpf, DadosPessoa.class);
    }

    private Pessoa getPessoaPorId(UUID id) {
        return repository.getPessoaRepository().findById(id)
                .orElseThrow(() -> new EntityNotFoundException("pessoa não encontrada"));
    }
    @Transactional
    public DadosPessoa salvar(DadosCadastroPessoa dados) {
        var pessoa = mapper.map(dados, Pessoa.class);
        repository.getPessoaRepository().save(pessoa);
        return mapper.map(pessoa, DadosPessoa.class);
    }

    @Transactional
    public DadosPessoa salvarpessoaFacade(DadosCadastroPessoa dados) {
        var pessoa = pessoaFacade.cria(dados);
        return mapper.map(pessoa, DadosPessoa.class);
    }


    public void delete(UUID id) {
        repository.getPessoaRepository().deleteById(id);
    }

    public DadosPessoa atualizar(UUID id, @Valid DadosCadastroPessoa dado) {
        Pessoa pessoa = mapper.map(dado,Pessoa.class);
        pessoa.setId(id);
        pessoa = repository.getPessoaRepository().save(pessoa);
        return mapper.map(pessoa, DadosPessoa.class);

    }

    public DadosPessoa salvarContatos(UUID id, DadosCadastroContato dado) {
        var pessoa = getPessoaPorId(id);
        var contato = mapper.map(dado, Contato.class);


        contato = repository.getContatoRepository().save(contato);
        pessoa.setContato(contato);
        pessoa = repository.getPessoaRepository().save(pessoa);
        return mapper.map(pessoa, DadosPessoa.class);


    }

    public DadosPessoa salvarMilitar(UUID id, DadosCadastroMilitar dados) {
        var pessoa = getPessoaPorId(id);
        var militar = mapper.map(dados, Militar.class);
        militar = repository.getMilitarRepository().save(militar);
        pessoa.setMilitar(militar);
        pessoa = repository.getPessoaRepository().save(pessoa);
        return mapper.map(pessoa, DadosPessoa.class);
    }


    public DadosPessoa criarSecao(UUID id, DadosCadastroPessoa dado) {
            var pessoa = getPessoaPorId(id);
            var setor = dado.getSetor().stream()
                    .map(repository.getSecaoRepository()::save).toList();
            pessoa.setSetor(setor);
            pessoa = repository.getPessoaRepository().save(pessoa);
            return mapper.map(pessoa, DadosPessoa.class);

    }

    public List<DadosDependente> dependentes(UUID id) {
        var pessoa = repository.getPessoaRepository().findById(id)
                .orElseThrow(() -> new EntityNotFoundException("pessoa não encontrada"));
        return pessoa.getDependentes().stream().map(d -> mapper.map(d, DadosDependente.class)).toList();
    }
}
