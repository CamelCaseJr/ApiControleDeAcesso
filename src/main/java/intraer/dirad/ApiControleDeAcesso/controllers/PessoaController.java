package intraer.dirad.ApiControleDeAcesso.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.contato.validacoes.DadosCadastroContato;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes.DadosCadastroDependente;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes.DadosDependente;
import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.secao.validacoes.DadosCadastroSecao;
import jakarta.transaction.Transactional;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import intraer.dirad.ApiControleDeAcesso.domain.pessoa.validacoes.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.validacoes.DadosPessoa;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.PessoaService;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {


    private final PessoaService pessoaService;
    Optional<Pessoa> optionalPessoa;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping()
    @Cacheable(value = "listaDePessoas")
    public ResponseEntity<Page<DadosPessoa>> findAll(Pageable paginacao) {

        return ResponseEntity.ok().body(pessoaService.findAll(paginacao));
    }

    @GetMapping("/{id}")
    @Cacheable(value = "findPessoaById")
    public ResponseEntity<DadosPessoa> findById(
        @PathVariable("id") UUID id
    ){
        return ResponseEntity.ok().body(pessoaService.findById(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<DadosPessoa>> findByNome(
            @PathVariable("nome") String nome
    ){
        return ResponseEntity.ok().body(pessoaService.findByNome(nome));
    }
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<DadosPessoa> findByCpf(
            @PathVariable("cpf") String cpf
    ){
        return ResponseEntity.ok().body(pessoaService.findByCpf(cpf));
    }
    @Transactional
    @PostMapping()
    @CacheEvict(value = "listaDePessoas", allEntries = true )
    public ResponseEntity<DadosPessoa> cadastrar(
        @RequestBody @Valid DadosCadastroPessoa dados,
        UriComponentsBuilder uriBuilder
    ){
        var pessoa = pessoaService.salvar(dados);
        var uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);

    }
    @Transactional
    @PutMapping("/{id}")
    @CacheEvict(value = "listaDePessoas", allEntries = true )
    public ResponseEntity<DadosPessoa> atualizar(@PathVariable ("id") UUID id,
        @RequestBody @Valid DadosCadastroPessoa dado
    ){
        return ResponseEntity.ok().body(pessoaService.atualizar(id,dado));
    }

    @Transactional
    @DeleteMapping("/{id}")
    @CacheEvict(value = "lista-de-pessoas", allEntries = true )
    public ResponseEntity<String> deletar(
        @PathVariable ("id") UUID id
    ) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}/dependentes")
    public ResponseEntity<List<DadosDependente>> findDependentes(
            @PathVariable("id") UUID id
    ){
        return ResponseEntity.ok().body(pessoaService.dependentes(id));
    }
    @PostMapping("/{id}/dependentes")
    @CacheEvict(value = "lista-de-pessoas", allEntries = true )
    public ResponseEntity<DadosPessoa> salvarDependentes(
            @PathVariable("id") UUID id, @RequestBody @Valid DadosCadastroDependente dependente
    ){
        return ResponseEntity.ok().body(pessoaService.salvarDependentes(id,dependente ));
    }

    @Transactional
    @PostMapping("/{id}/contatos")
    @CacheEvict(value = "lista-de-pessoas", allEntries = true )
    public ResponseEntity<DadosPessoa> salvarContatos(@PathVariable ("id") UUID id,
                                                @RequestBody @Valid DadosCadastroContato dado)
    {
        return ResponseEntity.ok().body(pessoaService.salvarContatos(id,dado));
    }
    @Transactional
    @PostMapping("/{id}/militares")
    @CacheEvict(value = "lista-de-pessoas", allEntries = true )
    public ResponseEntity<DadosPessoa> salvarMilitar(@PathVariable ("id") UUID id,
                                                @RequestBody @Valid DadosCadastroMilitar dado)
    {

        return ResponseEntity.ok().body(pessoaService.salvarMilitar(id,dado));
    }
    @Transactional
    @PostMapping("/{id}/secoes")
    @CacheEvict(value = "lista-de-pessoas", allEntries = true )
    public ResponseEntity<DadosPessoa> criarSecao(@PathVariable ("id") UUID id,
                                                @RequestBody @Valid DadosCadastroSecao dado)
    {
        return ResponseEntity.ok().body(pessoaService.criarSecao(id,dado));
    }

}


