package intraer.dirad.ApiControleDeAcesso.domain.militar;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitarService;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.validacoes.DadosCadastroOrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.PessoaService;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.validacoes.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.validacoes.DadosPessoa;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosAtualizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosMilitar;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class MilitarService {
    private final MilitarRepository repository;
    private final PessoaService pessoaService;
    private final OrganizacaoMilitarService organizacaoMilitarService;
    private final ModelMapper mapper;

    public Page<DadosMilitar> findAll(Pageable paginacao) {
        return repository.findAll(paginacao).map(Dados Militar::new);
    }

    public DadosMilitar findById(UUID id) {
        Militar militar = repository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("Militar não encontrado"));
        return mapper.map(militar, DadosMilitar.class);
    }
    @Transactional
    public DadosMilitar salvar(@Valid DadosCadastroMilitar dados) {
        Militar militar = getMilitar(dados);
        repository.save(militar);
        return mapper.map(militar, DadosMilitar.class);
    }

    private Militar getMilitar(DadosCadastroMilitar dados) {
        var militar = mapper.map(dados, Militar.class);

        OrganizacaoMilitar orgMilitar = salvarOrgMilitar(dados);
        Pessoa pessoa = salvarPessoa(dados);

        militar.setPessoa(pessoa);
        militar.setOm(orgMilitar);
        return militar;
    }

    private OrganizacaoMilitar salvarOrgMilitar(DadosCadastroMilitar dados) {
        var dadosCadastroOrganizacaoMilitar = mapper.map(dados.getOm(), DadosCadastroOrganizacaoMilitar.class);
        var dadosOrganizacaoMilitar = organizacaoMilitarService.salvar(dadosCadastroOrganizacaoMilitar);
        return mapper.map(dadosOrganizacaoMilitar, OrganizacaoMilitar.class);

    }

    private Pessoa salvarPessoa(DadosCadastroMilitar dados) {
        var dadosCadastroPessoa = mapper.map( dados.getPessoa(), DadosCadastroPessoa.class);
        var dadosPessoa = pessoaService.salvar(dadosCadastroPessoa);
        return DadosPessoa.convertPessoa(dadosPessoa);

    }

    public DadosMilitar atualizar(UUID id, @Valid DadosAtualizacaoMilitar dado) {
        var militar = mapper.map(dado, Militar.class);
        militar = repository.save(militar);
        return mapper.map(militar, DadosMilitar.class);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
    
}
