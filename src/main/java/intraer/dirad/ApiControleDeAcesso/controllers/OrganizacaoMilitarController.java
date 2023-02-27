package intraer.dirad.ApiControleDeAcesso.controllers;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosMilitar;
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
    public ResponseEntity<Page<DadosOrganizacaoMilitar>> findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
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
    public ResponseEntity<DadosOrganizacaoMilitar> cadastrar(
        @RequestBody @Valid DadosCadastroMilitar dados, UriComponentsBuilder uriBuilder
    ) {
        var militar = organizacaoMilitarService.salvar(dados);
        var uri = uriBuilder.path("/organizacoes-militares/{id}").buildAndExpand(militar.getId()).toUri();
        return ResponseEntity.created(uri).body(militar);
        
    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosOrganizacaoMilitar> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosAtualizacaoOrganizacaoMilitar dado) {
    
        return ResponseEntity.ok().body(organizacaoMilitarService.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        organizacaoMilitarService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
