package intraer.dirad.ApiControleDeAcesso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import intraer.dirad.ApiControleDeAcesso.Dto.PessoaDto;
import intraer.dirad.ApiControleDeAcesso.model.Pessoa;
import intraer.dirad.ApiControleDeAcesso.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    PessoaService pessoaService;
    
    public PessoaController( PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/bustarTodos")
    public ResponseEntity<List<Pessoa>> getAllPessoas() {
        
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(PessoaDto.ConverterPessoa(PessoaService.findAll()));
        
    }

    


}
