package intraer.dirad.ApiControleDeAcesso.controllers;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.validacoes.DadosCadastroOrganizacaoMilitar;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.validacoes.DadosAtualizacaoOrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.validacoes.DadosOrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/organizacoes-militares")
@AllArgsConstructor
public class OrganizacaoMilitarController {

    private final OrganizacaoMilitarService organizacaoMilitarService;

    @GetMapping
    @Cacheable(value = "listaOrganizacoes-militares")
    public ResponseEntity<Page<DadosOrganizacaoMilitar>> findAll( Pageable paginacao) {
        return ResponseEntity.ok().body(organizacaoMilitarService.findAll(paginacao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosOrganizacaoMilitar> findById(
        @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(organizacaoMilitarService.findById(id));
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaOrganizacoes-militares",allEntries = true)
    public ResponseEntity<DadosOrganizacaoMilitar> cadastrar(
        @RequestBody @Valid DadosCadastroOrganizacaoMilitar dados, UriComponentsBuilder uriBuilder
    ) {
        var organizacaoMilitar = organizacaoMilitarService.salvar(dados);
        var uri = uriBuilder.path("/organizacoes-militares/{id}").buildAndExpand(organizacaoMilitar.getId()).toUri();
        return ResponseEntity.created(uri).body(organizacaoMilitar);
        
    }

    @PutMapping(value="/{id}")
    @Transactional
    @CacheEvict(value = "listaOrganizacoes-militares",allEntries = true)
    public ResponseEntity<DadosOrganizacaoMilitar> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosAtualizacaoOrganizacaoMilitar dado) {
    
        return ResponseEntity.ok().body(organizacaoMilitarService.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    @CacheEvict(value = "listaOrganizacoes-militares",allEntries = true)
    public ResponseEntity excluir(@PathVariable UUID id) {
        organizacaoMilitarService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
