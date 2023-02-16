package intraer.dirad.ApiControleDeAcesso.controllers;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador.DadosAtualizacaoColaborador;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador.DadosCadastroColaborador;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador.DadosColaborador;
import intraer.dirad.ApiControleDeAcesso.services.ColaboradorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/colaboradores")
@AllArgsConstructor
public class ColaboradorController {
    
    private final ColaboradorService colaboradorService;
    @GetMapping
    public ResponseEntity<List<DadosColaborador>> listarTodos() {
        return ResponseEntity.ok().body(colaboradorService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosColaborador> findById(
        @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(colaboradorService.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosColaborador> cadastrar(
        @RequestBody @Valid DadosCadastroColaborador dados, UriComponentsBuilder uriBuilder
    ) {
        DadosColaborador colaborador = colaboradorService.salvar(dados);
        var uri = uriBuilder.path("/colaboradores/{id}").buildAndExpand(colaborador.getId()).toUri();
        return ResponseEntity.created(uri).body(colaborador);
        
    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosColaborador> atualizar(
            @PathVariable UUID id,
            @RequestBody @Valid DadosAtualizacaoColaborador dado,
            UriComponentsBuilder uriBuilder) {
        var uri = uriBuilder.path("/colaborador/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).body(colaboradorService.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        colaboradorService.delete(id);
        return ResponseEntity.noContent().build();
    }


    
}
