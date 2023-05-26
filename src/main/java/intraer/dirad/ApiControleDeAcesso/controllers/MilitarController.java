package intraer.dirad.ApiControleDeAcesso.controllers;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.gerente.validacoes.DadosGerente;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosAtualizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.militar.MilitarService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/militares")
@AllArgsConstructor
@CacheEvict(value = "listaDeMilitares", allEntries = true )
public class MilitarController {

    private final MilitarService militarService;

    @GetMapping
    @Cacheable(value = "listaMilitares")
    public ResponseEntity<Page<DadosMilitar>> findAll( Pageable paginacao) {
        return ResponseEntity.ok().body(militarService.findAll(paginacao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosMilitar> findById(
        @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(militarService.findById(id));
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaMilitares",allEntries = true)
    public ResponseEntity<DadosMilitar> cadastrar(
        @RequestBody @Valid DadosCadastroMilitar dados, UriComponentsBuilder uriBuilder
    ) {
        var militar = militarService.salvar(dados);
        var uri = uriBuilder.path("/militares/{id}").buildAndExpand(militar.getId()).toUri();
        return ResponseEntity.created(uri).body(militar);
        
    }

    @PutMapping(value="/{id}")
    @Transactional
    @CacheEvict(value = "listaMilitares",allEntries = true)
    public ResponseEntity<DadosMilitar> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosAtualizacaoMilitar dado) {
    
        return ResponseEntity.ok().body(militarService.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    @CacheEvict(value = "listaMilitares",allEntries = true)
    public ResponseEntity excluir(@PathVariable UUID id) {
        militarService.delete(id);
        return ResponseEntity.noContent().build();
    }

    
}
