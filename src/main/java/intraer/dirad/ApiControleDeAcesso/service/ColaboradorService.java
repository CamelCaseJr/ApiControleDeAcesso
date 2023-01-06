package intraer.dirad.ApiControleDeAcesso.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador.DadosAtualizacaoColaborador;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador.DadosCadastroColaborador;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador.DadosColaborador;
import intraer.dirad.ApiControleDeAcesso.model.Colaborador;
import intraer.dirad.ApiControleDeAcesso.model.Pessoa;
import jakarta.validation.Valid;

@Service
public class ColaboradorService {


    public List<DadosColaborador> findAll() {
        return null;
    }

    public DadosColaborador salvar(@Valid DadosCadastroColaborador dado) {
        return null;
    }

    public DadosColaborador getReferenceById(UUID id) {
        return null;
    }

    public DadosColaborador atualizar(UUID id, @Valid DadosAtualizacaoColaborador dado) {
        return null;
    }

    public void delete(UUID id) {
    }

    public DadosColaborador findById(UUID id) {
        return null;
    }

}
