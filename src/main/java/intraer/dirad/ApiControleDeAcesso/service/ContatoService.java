package intraer.dirad.ApiControleDeAcesso.service;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosAtualizacaoContato;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosCadastroContato;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosContato;
import jakarta.validation.Valid;

public class ContatoService {

    public List<DadosContato>findAll() {
        return null;
    }

    public DadosContato salvar(@Valid DadosCadastroContato dados) {
        return null;
    }

    public static DadosContato atualizar(UUID id, @Valid DadosAtualizacaoContato dado) {
        return null;
    }

    public void delete(UUID id) {
    }

    public DadosContato findById(UUID id) {
        return null;
    }
    
}
