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

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPermissaoGerenteLocalAcesso.DadosAtualizacaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPermissaoGerenteLocalAcesso.DadosCadastroGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPermissaoGerenteLocalAcesso.DadosGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.services.PermissaoGerenteLocalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/permissoes-gerente-local")
@AllArgsConstructor
public class PermissaoGerenteLocalAcessoController {
    
    private final PermissaoGerenteLocalService permissaoGerenteLocalService;

    @GetMapping
    public ResponseEntity<List<DadosGerenteLocalAcesso>> listarTodos() {
        return ResponseEntity.ok().body(permissaoGerenteLocalService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosGerenteLocalAcesso> contatoId(
        @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(permissaoGerenteLocalService.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosGerenteLocalAcesso> cadastrar(
        @RequestBody @Valid DadosCadastroGerenteLocalAcesso dados, UriComponentsBuilder uriBuilder
    ) {
        var militar = permissaoGerenteLocalService.salvar(dados);
        var uri = uriBuilder.path("/contato/{id}").buildAndExpand(militar.id()).toUri();
        return ResponseEntity.created(uri).body(militar);
        
    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosGerenteLocalAcesso> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosAtualizacaoGerenteLocalAcesso dado) {
    
        return ResponseEntity.ok().body(permissaoGerenteLocalService.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        permissaoGerenteLocalService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
