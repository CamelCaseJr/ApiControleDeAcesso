package intraer.dirad.ApiControleDeAcesso.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDispositivosDeacesso.DadosAtualizacaoDispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDispositivosDeacesso.DadosCadastroDispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDispositivosDeacesso.DadosDispositivosDeAcesso;
import jakarta.validation.Valid;

@Service
public class DispositivoDeAcessoService {

    public List<DadosDispositivosDeAcesso> findAll() {
        return null;
    }

    public DadosDispositivosDeAcesso findById(UUID id) {
        return null;
    }

    public DadosDispositivosDeAcesso salvar(@Valid DadosCadastroDispositivoDeAcesso dados) {
        return null;
    }
    public DadosDispositivosDeAcesso atualizar(UUID id, @Valid DadosAtualizacaoDispositivoDeAcesso dados) {
        return null;
    }

    public void delete(UUID id) {
    }
    
}
