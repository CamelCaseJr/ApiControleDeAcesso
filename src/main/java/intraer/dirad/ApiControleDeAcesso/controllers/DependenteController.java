package intraer.dirad.ApiControleDeAcesso.controllers;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDependente.DadosCadastroDependente;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDependente.DadosDeAtualizacaoDependente;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDependente.DadosDependente;
import intraer.dirad.ApiControleDeAcesso.services.DependenteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<DadosDependente>> listarTodos() {
        return ResponseEntity.ok().body(dependenteService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosDependente> contatoId(
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
        var uri = uriBuilder.path("/contato/{id}").buildAndExpand(dependente.getId()).toUri();
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
