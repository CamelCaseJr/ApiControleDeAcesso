package intraer.dirad.ApiControleDeAcesso.controllers;

import intraer.dirad.ApiControleDeAcesso.domain.visita.validacoes.DadosCadastroVisita;
import intraer.dirad.ApiControleDeAcesso.domain.visita.validacoes.DadosVisita;
import intraer.dirad.ApiControleDeAcesso.domain.visita.VisitaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(("/pontosdeacesso"))
@AllArgsConstructor
public class VisitaController {

    private final VisitaService service;


    @GetMapping
    public ResponseEntity<List<DadosVisita>> listarTodos() {
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosVisita> findById(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosVisita> cadastrar(
            @RequestBody @Valid DadosCadastroVisita dados, UriComponentsBuilder uriBuilder
    ) {
        var visita = service.salvar(dados);
        var uri = uriBuilder.path("/visitas/{id}").buildAndExpand(visita.getId()).toUri();
        return ResponseEntity.created(uri).body(visita);

    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosVisita> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosCadastroVisita dado) {

        return ResponseEntity.ok().body(service.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
