package intraer.dirad.ApiControleDeAcesso.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPntoDeAcesso.DadosAtualizacaoPontoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPntoDeAcesso.DadosCadastroPontoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPntoDeAcesso.DadosPontoDeAcesso;
import jakarta.validation.Valid;

@Service
public class PontoDeAcessoService {

    public List<DadosPontoDeAcesso> findAll() {
        return null;
    }

    public DadosPontoDeAcesso findById(UUID id) {
        return null;
    }

    public DadosPontoDeAcesso salvar(@Valid DadosCadastroPontoDeAcesso dados) {
        return null;
    }

    public DadosPontoDeAcesso atualizar(UUID id, @Valid DadosAtualizacaoPontoDeAcesso dado) {
        return null;
    }

    public void delete(UUID id) {
    }
    
}
