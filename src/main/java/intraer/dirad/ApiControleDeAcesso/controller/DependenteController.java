package intraer.dirad.ApiControleDeAcesso.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDependente.DadosCadastroDependente;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDependente.DadosDeAtualizacaoDependente;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDependente.DadosDependente;
import intraer.dirad.ApiControleDeAcesso.service.DependenteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.var;

@RestController
@RequestMapping("/dependente")
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
        var uri = uriBuilder.path("/contato/{id}").buildAndExpand(dependente.id()).toUri();
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
