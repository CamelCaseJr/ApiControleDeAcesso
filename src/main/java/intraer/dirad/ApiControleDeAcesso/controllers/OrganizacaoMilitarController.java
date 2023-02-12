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

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoOrganizacaoMilitar.DadosAtualizacaoOrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoOrganizacaoMilitar.DadosOrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.services.OrganizacaoMilitarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/organizacao-militar")
@AllArgsConstructor
public class OrganizacaoMilitarController {

    private final OrganizacaoMilitarService organizacaoMilitarService;

    @GetMapping
    public ResponseEntity<List<DadosOrganizacaoMilitar>> listarTodos() {
        return ResponseEntity.ok().body(organizacaoMilitarService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosOrganizacaoMilitar> contatoId(
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
        var uri = uriBuilder.path("/contato/{id}").buildAndExpand(militar.getId()).toUri();
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
