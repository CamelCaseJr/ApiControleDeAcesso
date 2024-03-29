package intraer.dirad.ApiControleDeAcesso.controllers;

import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.validacoes.DadosDispositivosDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes.DadosAtualizacaoEmpresa;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes.DadosCadastroEmpresa;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes.DadosEmpresa;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.EmpresaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(("/empresas"))
@AllArgsConstructor
public class EmpresaController {

    private final EmpresaService service;


    @GetMapping
    @Cacheable(value = "lista-empresas")
    public ResponseEntity<Page<DadosEmpresa>> findAll(Pageable paginacao) {
        return ResponseEntity.ok().body(service.findAll(paginacao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosEmpresa> findById(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "lista-empresas", allEntries = true)
    public ResponseEntity<DadosEmpresa> cadastrar(
            @RequestBody @Valid DadosCadastroEmpresa dados, UriComponentsBuilder uriBuilder
    ) {
        var empresa = service.salvar(dados);
        var uri = uriBuilder.path("/empresas/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(empresa);

    }

    @PutMapping(value="/{id}")
    @Transactional
    @CacheEvict(value = "lista-empresas", allEntries = true)
    public ResponseEntity<DadosEmpresa> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosAtualizacaoEmpresa dado) {

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
