package intraer.dirad.ApiControleDeAcesso.controllers;

import intraer.dirad.ApiControleDeAcesso.domain.endereco.validacoes.DadosEndereco;
import intraer.dirad.ApiControleDeAcesso.domain.gerente.validacoes.DadosCadastroGerente;
import intraer.dirad.ApiControleDeAcesso.domain.gerente.validacoes.DadosGerente;
import intraer.dirad.ApiControleDeAcesso.domain.gerente.GerenteService;
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
@RequestMapping(("/gerentes"))
@AllArgsConstructor
public class GerenteController {

    private final GerenteService service;


    @GetMapping
    public ResponseEntity<Page<DadosGerente>> findAll(Pageable paginacao) {
        return ResponseEntity.ok().body(service.findAll(paginacao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosGerente> findById(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosGerente> cadastrar(
            @RequestBody @Valid DadosCadastroGerente dados, UriComponentsBuilder uriBuilder
    ) {
        var gerente = service.salvar(dados);
        var uri = uriBuilder.path("/gerentes/{id}").buildAndExpand(gerente.getId()).toUri();
        return ResponseEntity.created(uri).body(gerente);

    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosGerente> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosCadastroGerente dado) {

        return ResponseEntity.ok().body(service.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
