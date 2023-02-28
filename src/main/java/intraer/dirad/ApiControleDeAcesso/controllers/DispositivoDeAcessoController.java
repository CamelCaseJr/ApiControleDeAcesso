package intraer.dirad.ApiControleDeAcesso.controllers;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes.DadosDependente;
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

import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.validacoes.DadosAtualizacaoDispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.validacoes.DadosCadastroDispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.validacoes.DadosDispositivosDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.DispositivoDeAcessoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/dispositivo-de-acessos")
public class DispositivoDeAcessoController {
    private final DispositivoDeAcessoService dispositivoDeAcessoService;
    
    public DispositivoDeAcessoController(DispositivoDeAcessoService dispositivoDeAcessoService) {
        this.dispositivoDeAcessoService = dispositivoDeAcessoService;
    }
    @GetMapping
    public ResponseEntity<Page<DadosDispositivosDeAcesso>> findAll( Pageable paginacao) {
        return ResponseEntity.ok().body(dispositivoDeAcessoService.findAll(paginacao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosDispositivosDeAcesso> findById(
        @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(dispositivoDeAcessoService.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDispositivosDeAcesso> cadastrar(
        @RequestBody @Valid DadosCadastroDispositivoDeAcesso dados, UriComponentsBuilder uriBuilder
    ) {
        var dependente = dispositivoDeAcessoService.salvar(dados);
        var uri = uriBuilder.path("/dispositivo-de-acessos/{id}").buildAndExpand(dependente.getId()).toUri();
        return ResponseEntity.created(uri).body(dependente);
        
    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosDispositivosDeAcesso> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosAtualizacaoDispositivoDeAcesso dado) {
    
        return ResponseEntity.ok().body(dispositivoDeAcessoService.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        dispositivoDeAcessoService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
