package intraer.dirad.ApiControleDeAcesso.controller;

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

import intraer.dirad.ApiControleDeAcesso.Dto.PessoaDto;
import intraer.dirad.ApiControleDeAcesso.form.PessoaForm;
import intraer.dirad.ApiControleDeAcesso.model.Pessoa;
import intraer.dirad.ApiControleDeAcesso.service.PessoaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {


    private final PessoaService pessoaService;
    Optional<Pessoa> optionalPessoa;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/listarPessoas")
    public ResponseEntity<List<PessoaDto>> getAllPessoas() {
        
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(PessoaDto.ConverterPessoa(pessoaService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> getPessoaId(
        @RequestParam("id") UUID id
    ){
        optionalPessoa = pessoaService.findById(id);
        return optionalPessoa.map(pessoa -> ResponseEntity
        .status(HttpStatus.OK)
        .body(PessoaDto.ConverterPessoa(pessoaService.findById(id).get())))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    
    @PostMapping("/salvar")
    public ResponseEntity<PessoaDto> salvar(
        @RequestBody @Valid PessoaForm pessoaForm
    ){
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(PessoaDto.ConverterPessoa(pessoaService.salvar(pessoaForm)));
        
    }

    @PutMapping("/atualizar")
    public ResponseEntity<PessoaDto> atualizar(
        @RequestBody @Valid PessoaForm pessoaForm
    ){
        return ResponseEntity
        .status(HttpStatus.OK)
        .body(PessoaDto.ConverterPessoa(pessoaService.salvar(pessoaForm)));
    }

    @DeleteMapping("/deletar/{id}")
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


