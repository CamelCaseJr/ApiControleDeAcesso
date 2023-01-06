package intraer.dirad.ApiControleDeAcesso.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador.DadosAtualizacaoColaborador;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador.DadosCadastroColaborador;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador.DadosColaborador;
import intraer.dirad.ApiControleDeAcesso.model.Colaborador;
import intraer.dirad.ApiControleDeAcesso.service.ColaboradorService;
import intraer.dirad.ApiControleDeAcesso.service.EmpresaService;
import intraer.dirad.ApiControleDeAcesso.service.PessoaService;
import jakarta.validation.Valid;
import lombok.var;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
    
    private final ColaboradorService colaboradorService;
    private final PessoaService pessoaService;
    private final EmpresaService empresaService;

    public ColaboradorController(ColaboradorService colaboradorService, PessoaService pessoaService,
            EmpresaService empresaService) {
        this.colaboradorService = colaboradorService;
        this.pessoaService = pessoaService;
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<List<DadosColaborador>> listarTodos() {
        return ResponseEntity.ok().body(colaboradorService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosColaborador> contatoId(
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
        var uri = uriBuilder.path("/colaborador/{id}").buildAndExpand(colaborador.id()).toUri();
        return ResponseEntity.created(uri).body(colaborador);
        
    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosColaborador> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosAtualizacaoColaborador dado) {
    
        return ResponseEntity.ok().body(colaboradorService.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        colaboradorService.delete(id);
        return ResponseEntity.noContent().build();
    }


    
}
