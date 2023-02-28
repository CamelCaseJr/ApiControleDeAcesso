package intraer.dirad.ApiControleDeAcesso.controllers;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.validacoes.DadosGerenteLocalAcesso;
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

import intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.validacoes.DadosAtualizacaoPontoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.validacoes.DadosCadastroPontoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.validacoes.DadosPontoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.PontoDeAcessoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/pontos-de-acesso")
@AllArgsConstructor
public class PontoDeAcessoController {
    
    private final PontoDeAcessoService pontoDeAcessoService;

    @GetMapping
    public ResponseEntity<Page<DadosPontoDeAcesso>> findAll( Pageable paginacao) {
        return ResponseEntity.ok().body(pontoDeAcessoService.findAll(paginacao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosPontoDeAcesso> findById(
        @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(pontoDeAcessoService.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosPontoDeAcesso> cadastrar(
        @RequestBody @Valid DadosCadastroPontoDeAcesso dados, UriComponentsBuilder uriBuilder
    ) {
        var pontoDeAcesso = pontoDeAcessoService.salvar(dados);
        var uri = uriBuilder.path("/pontos-de-acesso/{id}").buildAndExpand(pontoDeAcesso.getId()).toUri();
        return ResponseEntity.created(uri).body(pontoDeAcesso);
        
    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosPontoDeAcesso> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosAtualizacaoPontoDeAcesso dado) {
    
        return ResponseEntity.ok().body(pontoDeAcessoService.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        pontoDeAcessoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
