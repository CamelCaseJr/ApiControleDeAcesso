package intraer.dirad.ApiControleDeAcesso.controllers;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoGerente.DadosCadastroGerente;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoGerente.DadosGerente;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoResponsavel.DadosAtualizacaoResponsavel;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoResponsavel.DadosCadastroResponsavel;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoResponsavel.DadosResponsavel;
import intraer.dirad.ApiControleDeAcesso.services.GerenteService;
import intraer.dirad.ApiControleDeAcesso.services.ResponsavelService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(("/responsaveis"))
@AllArgsConstructor
public class ResponsavelController {

    private final ResponsavelService service;


    @GetMapping
    public ResponseEntity<List<DadosResponsavel>> listarTodos() {
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosResponsavel> findById(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosResponsavel> cadastrar(
            @RequestBody @Valid DadosCadastroResponsavel dados, UriComponentsBuilder uriBuilder
    ) {
        var responsavel = service.salvar(dados);
        var uri = uriBuilder.path("/responsaveis/{id}").buildAndExpand(responsavel.getId()).toUri();
        return ResponseEntity.created(uri).body(responsavel);

    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosResponsavel> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosAtualizacaoResponsavel dado) {

        return ResponseEntity.ok().body(service.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
