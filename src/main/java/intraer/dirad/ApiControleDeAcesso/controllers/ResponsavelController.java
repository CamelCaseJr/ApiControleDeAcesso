package intraer.dirad.ApiControleDeAcesso.controllers;

import intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.validacoes.DadosPontoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.validacoes.DadosAtualizacaoResponsavel;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.validacoes.DadosCadastroResponsavel;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.validacoes.DadosResponsavel;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.ResponsavelService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<Page<DadosResponsavel>> findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return ResponseEntity.ok().body(service.findAll(paginacao));
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
