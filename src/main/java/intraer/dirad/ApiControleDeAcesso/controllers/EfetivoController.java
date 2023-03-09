package intraer.dirad.ApiControleDeAcesso.controllers;

import intraer.dirad.ApiControleDeAcesso.domain.efetivo.Efetivo;
import intraer.dirad.ApiControleDeAcesso.domain.efetivo.EfetivoService;
import intraer.dirad.ApiControleDeAcesso.domain.efetivo.validacoes.DadosCadastroEfetivo;
import intraer.dirad.ApiControleDeAcesso.domain.efetivo.validacoes.DadosEfetivo;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.EmpresaService;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes.DadosCadastroEmpresa;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes.DadosEmpresa;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping(("/efetivo"))
@AllArgsConstructor
public class EfetivoController {

    private final EfetivoService service;


    @GetMapping
    @Cacheable(value = "lista-empresas")
    public ResponseEntity<Page<DadosEfetivo>> findAll(Pageable paginacao) {
        return ResponseEntity.ok().body(service.findAll(paginacao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosEfetivo> findById(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "lista-empresas", allEntries = true)
    public ResponseEntity<DadosEfetivo> cadastrar(
            @RequestBody @Valid DadosCadastroEfetivo dados, UriComponentsBuilder uriBuilder
    ) {
        var efetivo = service.salvar(dados);
        var uri = uriBuilder.path("/empresas/{id}").buildAndExpand(efetivo.getId()).toUri();
        return ResponseEntity.created(uri).body(efetivo);

    }

    @PutMapping(value="/{id}")
    @Transactional
    @CacheEvict(value = "lista-empresas", allEntries = true)
    public ResponseEntity<DadosEfetivo> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosCadastroEfetivo dado) {

        return ResponseEntity.ok().body(service.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    @CacheEvict(value = "lista-empresas", allEntries = true)
    public ResponseEntity excluir(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
