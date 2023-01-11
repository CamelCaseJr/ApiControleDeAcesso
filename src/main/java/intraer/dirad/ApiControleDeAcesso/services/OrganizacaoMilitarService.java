package intraer.dirad.ApiControleDeAcesso.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoOrganizacaoMilitar.DadosAtualizacaoOrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoOrganizacaoMilitar.DadosOrganizacaoMilitar;
import jakarta.validation.Valid;

@Service
public class OrganizacaoMilitarService {

    public List<DadosOrganizacaoMilitar> findAll() {
        return null;
    }

    public DadosOrganizacaoMilitar findById(UUID id) {
        return null;
    }

    public DadosOrganizacaoMilitar salvar(@Valid DadosCadastroMilitar dados) {
        return null;
    }

    public DadosOrganizacaoMilitar atualizar(UUID id, @Valid DadosAtualizacaoOrganizacaoMilitar dado) {
        return null;
    }

    public void delete(UUID id) {
    }
    
}
