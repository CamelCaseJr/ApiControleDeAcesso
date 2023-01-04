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

import intraer.dirad.ApiControleDeAcesso.Dto.DadosAtualizacaoColaborador;
import intraer.dirad.ApiControleDeAcesso.Dto.DadosCadastroColaborador;
import intraer.dirad.ApiControleDeAcesso.Dto.DadosColaborador;
import intraer.dirad.ApiControleDeAcesso.model.Colaborador;
import intraer.dirad.ApiControleDeAcesso.service.ColaboradorService;
import intraer.dirad.ApiControleDeAcesso.service.EmpresaService;
import intraer.dirad.ApiControleDeAcesso.service.PessoaService;
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

    @PostMapping
    @Transactional
    public ResponseEntity<DadosColaborador> cadastrar(
        @PathVariable UUID pessoaId,
        @PathVariable UUID empresaId,
        UriComponentsBuilder uBuilder
    ) {
        DadosColaborador colaborador = colaboradorService.salvar(pessoaId,empresaId);
        var uri = uBuilder.path("/medicos/{id}").buildAndExpand(colaborador.id()).toUri();
        return ResponseEntity.created(uri).body(colaborador);
        
    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosColaborador> atualizar(@PathVariable UUID id, @RequestBody DadosAtualizacaoColaborador dado) {
    
        return ResponseEntity.ok().body(colaboradorService.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        colaboradorService.delete(id);
        return ResponseEntity.noContent().build();
    }


    
}
