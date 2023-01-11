package intraer.dirad.ApiControleDeAcesso.controllers;

import java.util.List;
import java.util.UUID;

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

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPntoDeAcesso.DadosAtualizacaoPontoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPntoDeAcesso.DadosCadastroPontoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPntoDeAcesso.DadosPontoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.services.PontoDeAcessoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
public class PontoDeAcessoController {
    
    private final PontoDeAcessoService pontoDeAcessoService;

    @GetMapping
    public ResponseEntity<List<DadosPontoDeAcesso>> listarTodos() {
        return ResponseEntity.ok().body(pontoDeAcessoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosPontoDeAcesso> contatoId(
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
        var uri = uriBuilder.path("/contato/{id}").buildAndExpand(pontoDeAcesso.id()).toUri();
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
