package intraer.dirad.ApiControleDeAcesso.controllers;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.validacoes.DadosOrganizacaoMilitar;
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

import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.validacoes.DadosAtualizacaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.validacoes.DadosCadastroGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.validacoes.DadosGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.PermissaoGerenteLocalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/permissoes-gerente-local")
@AllArgsConstructor
public class PermissaoGerenteLocalAcessoController {
    
    private final PermissaoGerenteLocalService permissaoGerenteLocalService;

    @GetMapping
    @Cacheable(value = "lista-permissoes-gerente-local")
    public ResponseEntity<Page<DadosGerenteLocalAcesso>> findAll( Pageable paginacao) {
        return ResponseEntity.ok().body(permissaoGerenteLocalService.findAll(paginacao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosGerenteLocalAcesso> findById(
        @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(permissaoGerenteLocalService.findById(id));
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "lista-permissoes-gerente-local",allEntries = true)
    public ResponseEntity<DadosGerenteLocalAcesso> cadastrar(
        @RequestBody @Valid DadosCadastroGerenteLocalAcesso dados, UriComponentsBuilder uriBuilder
    ) {
        var militar = permissaoGerenteLocalService.salvar(dados);
        var uri = uriBuilder.path("/permissoes-gerente-local/{id}").buildAndExpand(militar.getId()).toUri();
        return ResponseEntity.created(uri).body(militar);
        
    }

    @PutMapping(value="/{id}")
    @Transactional
    @CacheEvict(value = "lista-permissoes-gerente-local",allEntries = true)
    public ResponseEntity<DadosGerenteLocalAcesso> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosAtualizacaoGerenteLocalAcesso dado) {
    
        return ResponseEntity.ok().body(permissaoGerenteLocalService.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    @CacheEvict(value = "lista-permissoes-gerente-local",allEntries = true)
    public ResponseEntity excluir(@PathVariable UUID id) {
        permissaoGerenteLocalService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
