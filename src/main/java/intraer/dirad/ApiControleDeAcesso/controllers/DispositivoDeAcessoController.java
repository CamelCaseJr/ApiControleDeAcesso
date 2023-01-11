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

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDispositivosDeacesso.DadosAtualizacaoDispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDispositivosDeacesso.DadosCadastroDispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDispositivosDeacesso.DadosDispositivosDeAcesso;
import intraer.dirad.ApiControleDeAcesso.services.DispositivoDeAcessoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/dispositivoDeAcessos")
public class DispositivoDeAcessoController {
    private final DispositivoDeAcessoService dispositivoDeAcessoService;
    
    public DispositivoDeAcessoController(DispositivoDeAcessoService dispositivoDeAcessoService) {
        this.dispositivoDeAcessoService = dispositivoDeAcessoService;
    }
    @GetMapping
    public ResponseEntity<List<DadosDispositivosDeAcesso>> listarTodos() {
        return ResponseEntity.ok().body(dispositivoDeAcessoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosDispositivosDeAcesso> contatoId(
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
        var uri = uriBuilder.path("/contato/{id}").buildAndExpand(dependente.id()).toUri();
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
