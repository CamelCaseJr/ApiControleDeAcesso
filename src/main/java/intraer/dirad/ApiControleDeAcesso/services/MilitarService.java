package intraer.dirad.ApiControleDeAcesso.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar.DadosAtualizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar.DadosMilitar;
import jakarta.validation.Valid;


@Service
public class MilitarService {

    public List<DadosMilitar> findAll() {
        return null;
    }

    public DadosMilitar findById(UUID id) {
        return null;
    }

    public DadosMilitar salvar(@Valid DadosCadastroMilitar dados) {
        return null;
    }

    public DadosMilitar atualizar(UUID id, @Valid DadosAtualizacaoMilitar dado) {
        return null;
    }

    public void delete(UUID id) {
    }
    
}
