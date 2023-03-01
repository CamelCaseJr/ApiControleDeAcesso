package intraer.dirad.ApiControleDeAcesso.domain.pessoa;

import intraer.dirad.ApiControleDeAcesso.domain.contato.validacoes.DadosCadastroContato;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.Dependente;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes.DadosCadastroDependente;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes.DadosDependente;
import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.validacoes.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.validacoes.DadosPessoa;
import intraer.dirad.ApiControleDeAcesso.domain.secao.Secao;
import intraer.dirad.ApiControleDeAcesso.domain.secao.validacoes.DadosCadastroSecao;
import intraer.dirad.ApiControleDeAcesso.facade.PessoaFacade;
import intraer.dirad.ApiControleDeAcesso.domain.contato.Contato;
import intraer.dirad.ApiControleDeAcesso.domain.militar.Militar;
import intraer.dirad.ApiControleDeAcesso.domain.RepositorioGlobal;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PessoaService {

    private final RepositorioGlobal repository;
    private final ModelMapper mapper;
    private final PessoaFacade pessoaFacade;




    public Page<DadosPessoa> findAll(Pageable paginacao) {
        return repository.getPessoaRepository().findAll(paginacao).map(DadosPessoa::new);

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

    public DadosPessoa salvar(DadosCadastroPessoa dados) {
        var pessoa = mapper.map(dados, Pessoa.class);

        boolean present = repository.getPessoaRepository().findByCpf(pessoa.getCpf()).isPresent();
        if (present) throw new EntityNotFoundException("cpf já está cadastrado");

        repository.getPessoaRepository().save(pessoa);
        return mapper.map(pessoa, DadosPessoa.class);
    }

 /*   @Transactional
    public DadosPessoa salvarpessoaFacade(DadosCadastroPessoa dados) {
        var pessoa = pessoaFacade.cria(dados);
        return mapper.map(pessoa, DadosPessoa.class);
    }*/


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


    public DadosPessoa criarSecao(UUID id, DadosCadastroSecao dado) {
            var pessoa = getPessoaPorId(id);
            var setor = mapper.map(dado, Secao.class);
            pessoa.getSetor().add(setor);
            pessoa = repository.getPessoaRepository().save(pessoa);
            return mapper.map(pessoa, DadosPessoa.class);

    }

    public List<DadosDependente> dependentes(UUID id) {
        var pessoa = repository.getPessoaRepository().findById(id)
                .orElseThrow(() -> new EntityNotFoundException("pessoa não encontrada"));
        return pessoa.getDependentes().stream().map(d -> mapper.map(d, DadosDependente.class)).toList();
    }

    public DadosPessoa salvarDependentes(UUID id, DadosCadastroDependente dados) {
        var pessoa = getPessoaPorId(id);
        var dependente = mapper.map(dados, Dependente.class);
        pessoa.getDependentes().add(dependente);
        pessoa = repository.getPessoaRepository().save(pessoa);
        return mapper.map(pessoa, DadosPessoa.class);
    }
}
