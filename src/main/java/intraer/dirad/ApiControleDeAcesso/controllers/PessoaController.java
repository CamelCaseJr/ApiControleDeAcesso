package intraer.dirad.ApiControleDeAcesso.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosPessoa;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.services.PessoaService;
import jakarta.validation.Valid;

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
        
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(DadosPessoa.ConverterPessoa(pessoaService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosPessoa> getPessoaId(
        @RequestParam("id") UUID id
    ){
        optionalPessoa = pessoaService.findById(id);
        return optionalPessoa.map(pessoa -> ResponseEntity
        .status(HttpStatus.OK)
        .body(DadosPessoa.ConverterPessoa(pessoaService.findById(id).get())))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    
    @PostMapping()
    public ResponseEntity<DadosPessoa> cadastrar(
        @RequestBody @Valid DadosCadastroPessoa pessoaForm
    ){
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(DadosPessoa.ConverterPessoa(pessoaService.salvar(pessoaForm)));
        
    }

    @PutMapping()
    public ResponseEntity<DadosPessoa> atualizar(
        @RequestBody @Valid DadosCadastroPessoa pessoaForm
    ){
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(DadosPessoa.ConverterPessoa(pessoaService.salvar(pessoaForm)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(
        @RequestParam ("id") UUID id
    ) {
        optionalPessoa = pessoaService.findById(id); 
        return optionalPessoa.map(pessoa -> ResponseEntity
        .ok()
        .body(pessoaService.deletar(pessoa)))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        
    }




}


