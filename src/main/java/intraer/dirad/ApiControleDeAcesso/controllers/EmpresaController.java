package intraer.dirad.ApiControleDeAcesso.controllers;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoEmpresa.DadosCadastroEmpresa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoEmpresa.DadosEmpresa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoSecao.DadosAtualizacaoSecao;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoSecao.DadosCadastroSecao;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoSecao.DadosSecao;
import intraer.dirad.ApiControleDeAcesso.services.EmpresaService;
import intraer.dirad.ApiControleDeAcesso.services.SecaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(("/empresas"))
@AllArgsConstructor
public class EmpresaController {

    private final EmpresaService service;


    @GetMapping
    public ResponseEntity<List<DadosEmpresa>> listarTodos() {
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosEmpresa> findById(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosEmpresa> cadastrar(
            @RequestBody @Valid DadosCadastroEmpresa dados, UriComponentsBuilder uriBuilder
    ) {
        var empresa = service.salvar(dados);
        var uri = uriBuilder.path("/empresas/{id}").buildAndExpand(empresa.getId()).toUri();
        return ResponseEntity.created(uri).body(empresa);

    }

    @PutMapping(value="/{id}")
    @Transactional
    public ResponseEntity<DadosEmpresa> atualizar(@PathVariable UUID id, @RequestBody @Valid DadosCadastroEmpresa dado) {

        return ResponseEntity.ok().body(service.atualizar(id,dado));
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
