package intraer.dirad.ApiControleDeAcesso.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosPessoa;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {


    private final PessoaService pessoaService;
    Optional<Pessoa> optionalPessoa;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping()
    public ResponseEntity<List<DadosPessoa>> getAllPessoas() {

        return ResponseEntity.ok().body(pessoaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosPessoa> getPessoaId(
        @PathVariable("id") UUID id
    ){
        return ResponseEntity.ok().body(pessoaService.findById(id));
    }

    
    @PostMapping()
    public ResponseEntity<DadosPessoa> cadastrar(
        @RequestBody @Valid DadosCadastroPessoa dados,
        UriComponentsBuilder uriBuilder
    ){
        var pessoa = pessoaService.salvar(dados);
        var uri = uriBuilder.path("/contato/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<DadosPessoa> atualizar(@PathVariable ("id") UUID id,
        @RequestBody @Valid DadosCadastroPessoa dado
    ){
        return ResponseEntity.ok().body(pessoaService.atualizar(id,dado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(
        @PathVariable ("id") UUID id
    ) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
        
    }




}


