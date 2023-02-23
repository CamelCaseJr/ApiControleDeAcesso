package intraer.dirad.ApiControleDeAcesso.controllers;

import intraer.dirad.ApiControleDeAcesso.domain.endereco.validacoes.DadosCadastroEndereco;
import intraer.dirad.ApiControleDeAcesso.domain.endereco.validacoes.DadosEndereco;
import intraer.dirad.ApiControleDeAcesso.domain.endereco.EnderecoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(("/enderecos"))
@AllArgsConstructor
public class EnderecoController {

    private final EnderecoService service;


    @GetMapping
    public ResponseEntity<List<DadosEndereco>> listarTodos() {
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosEndereco> findById(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosEndereco> cadastrar(
            @RequestBody @Valid DadosCadastroEndereco dados, UriComponentsBuilder uriBuilder
    ) {
        var endereco = service.salvar(dados);
        var uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(endereco);

    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosEndereco> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosCadastroEndereco dado) {

        return ResponseEntity.ok().body(service.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
