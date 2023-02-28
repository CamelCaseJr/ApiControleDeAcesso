package intraer.dirad.ApiControleDeAcesso.controllers;

import intraer.dirad.ApiControleDeAcesso.domain.contato.validacoes.DadosContato;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes.DadosCadastroDependente;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes.DadosDeAtualizacaoDependente;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes.DadosDependente;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.DependenteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dependentes")
public class DependenteController {
    private final DependenteService dependenteService;


    public DependenteController(DependenteService dependenteService) {
        this.dependenteService = dependenteService;
    }
    @GetMapping
    public ResponseEntity<Page<DadosDependente>> findAll( Pageable paginacao) {
        return ResponseEntity.ok().body(dependenteService.findAll(paginacao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosDependente> findById(
        @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(dependenteService.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDependente> cadastrar(
        @RequestBody @Valid DadosCadastroDependente dados, UriComponentsBuilder uriBuilder
    ) {
        var dependente = dependenteService.salvar(dados);
        var uri = uriBuilder.path("/dependentes/{id}").buildAndExpand(dependente.getId()).toUri();
        return ResponseEntity.created(uri).body(dependente);
        
    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosDependente> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosDeAtualizacaoDependente dado) {
    
        return ResponseEntity.ok().body(dependenteService.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        dependenteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
