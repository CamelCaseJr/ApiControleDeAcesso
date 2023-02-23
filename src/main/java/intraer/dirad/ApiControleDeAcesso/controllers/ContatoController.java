package intraer.dirad.ApiControleDeAcesso.controllers;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.colaborador.validacoes.DadosColaborador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import intraer.dirad.ApiControleDeAcesso.domain.contato.validacoes.DadosAtualizacaoContato;
import intraer.dirad.ApiControleDeAcesso.domain.contato.validacoes.DadosCadastroContato;
import intraer.dirad.ApiControleDeAcesso.domain.contato.validacoes.DadosContato;
import intraer.dirad.ApiControleDeAcesso.domain.contato.ContatoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public ResponseEntity<Page<DadosContato>> findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return ResponseEntity.ok().body(contatoService.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosContato> findById(
        @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(contatoService.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosContato> cadastrar(
        @RequestBody @Valid DadosCadastroContato dados, UriComponentsBuilder uriBuilder
    ) {
        DadosContato contato = contatoService.salvar(dados);
        var uri = uriBuilder.path("/contato/{id}").buildAndExpand(contato.getId()).toUri();
        return ResponseEntity.created(uri).body(contato);
        
    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosContato> atualizar(
            @PathVariable UUID id,
            @RequestBody @Valid DadosAtualizacaoContato dado,
            UriComponentsBuilder uriBuilder) {

        var uri = uriBuilder.path("/contato/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).body(contatoService.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        contatoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
