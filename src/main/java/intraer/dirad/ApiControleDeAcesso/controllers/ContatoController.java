package intraer.dirad.ApiControleDeAcesso.controllers;

import java.util.List;
import java.util.UUID;

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

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosAtualizacaoContato;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosCadastroContato;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosContato;
import intraer.dirad.ApiControleDeAcesso.services.ContatoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/contatos")
public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public ResponseEntity<List<DadosContato>> listarTodos() {
        return ResponseEntity.ok().body(contatoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosContato> contatoId(
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
        var uri = uriBuilder.path("/contato/{id}").buildAndExpand(contato.id()).toUri();
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
