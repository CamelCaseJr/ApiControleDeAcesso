package intraer.dirad.ApiControleDeAcesso.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPermissaoGerenteLocalAcesso.DadosAtualizacaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPermissaoGerenteLocalAcesso.DadosCadastroGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPermissaoGerenteLocalAcesso.DadosGerenteLocalAcesso;
import jakarta.validation.Valid;

@Service
public class PermissaoGerenteLocalService {

    public List<DadosGerenteLocalAcesso> findAll() {
        return null;
    }

    public DadosGerenteLocalAcesso findById(UUID id) {
        return null;
    }

    public DadosGerenteLocalAcesso salvar(@Valid DadosCadastroGerenteLocalAcesso dados) {
        return null;
    }

    public DadosGerenteLocalAcesso atualizar(UUID id, @Valid DadosAtualizacaoGerenteLocalAcesso dado) {
        return null;
    }

    public void delete(UUID id) {
    }
    
}
