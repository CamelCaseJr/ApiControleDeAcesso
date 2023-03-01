package intraer.dirad.ApiControleDeAcesso.controllers;

import intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes.DadosEmpresa;
import intraer.dirad.ApiControleDeAcesso.domain.endereco.validacoes.DadosCadastroEndereco;
import intraer.dirad.ApiControleDeAcesso.domain.endereco.validacoes.DadosEndereco;
import intraer.dirad.ApiControleDeAcesso.domain.endereco.EnderecoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    @Cacheable(value = "listarEnderecos")
    public ResponseEntity<Page<DadosEndereco>> findAll( Pageable paginacao) {
        return ResponseEntity.ok().body(service.findAll(paginacao));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosEndereco> findById(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listarEnderecos", allEntries = true)
    public ResponseEntity<DadosEndereco> cadastrar(
            @RequestBody @Valid DadosCadastroEndereco dados, UriComponentsBuilder uriBuilder
    ) {
        var endereco = service.salvar(dados);
        var uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(endereco);

    }

    @PutMapping(value="/{id}")
    @Transactional
    @CacheEvict(value = "listarEnderecos", allEntries = true)
    public ResponseEntity<DadosEndereco> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosCadastroEndereco dado) {

        return ResponseEntity.ok().body(service.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    @CacheEvict(value = "listarEnderecos", allEntries = true)
    public ResponseEntity excluir(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
