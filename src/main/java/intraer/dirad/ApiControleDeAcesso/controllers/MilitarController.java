package intraer.dirad.ApiControleDeAcesso.controllers;

import java.util.List;
import java.util.UUID;

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

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar.DadosAtualizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar.DadosMilitar;
import intraer.dirad.ApiControleDeAcesso.services.MilitarService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/militares")
@AllArgsConstructor
public class MilitarController {

    private final MilitarService militarService;

    @GetMapping
    public ResponseEntity<List<DadosMilitar>> listarTodos() {
        return ResponseEntity.ok().body(militarService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosMilitar> findById(
        @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(militarService.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosMilitar> cadastrar(
        @RequestBody @Valid DadosCadastroMilitar dados, UriComponentsBuilder uriBuilder
    ) {
        var militar = militarService.salvar(dados);
        var uri = uriBuilder.path("/militares/{id}").buildAndExpand(militar.getId()).toUri();
        return ResponseEntity.created(uri).body(militar);
        
    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosMilitar> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosAtualizacaoMilitar dado) {
    
        return ResponseEntity.ok().body(militarService.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        militarService.delete(id);
        return ResponseEntity.noContent().build();
    }

    
}
