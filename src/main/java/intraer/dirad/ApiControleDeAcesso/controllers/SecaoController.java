package intraer.dirad.ApiControleDeAcesso.controllers;

import intraer.dirad.ApiControleDeAcesso.domain.secao.validacoes.DadosAtualizacaoSecao;
import intraer.dirad.ApiControleDeAcesso.domain.secao.validacoes.DadosCadastroSecao;
import intraer.dirad.ApiControleDeAcesso.domain.secao.validacoes.DadosSecao;
import intraer.dirad.ApiControleDeAcesso.domain.secao.SecaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(("/secoes"))
@AllArgsConstructor
public class SecaoController {

    private final SecaoService service;


    @GetMapping
    public ResponseEntity<List<DadosSecao>> listarTodos() {
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosSecao> findById(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosSecao> cadastrar(
            @RequestBody @Valid DadosCadastroSecao dados, UriComponentsBuilder uriBuilder
    ) {
        var secao = service.salvar(dados);
        var uri = uriBuilder.path("/secoes/{id}").buildAndExpand(secao.getId()).toUri();
        return ResponseEntity.created(uri).body(secao);

    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosSecao> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosAtualizacaoSecao dado) {

        return ResponseEntity.ok().body(service.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
