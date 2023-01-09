package intraer.dirad.ApiControleDeAcesso.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDependente.DadosCadastroDependente;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDependente.DadosDeAtualizacaoDependente;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoDependente.DadosDependente;
import jakarta.validation.Valid;

@Service
public class DependenteService {

    public List<DadosDependente> findAll() {
        return null;
    }

    public DadosDependente findById(UUID id) {
        return null;
    }

    public DadosDependente salvar(@Valid DadosCadastroDependente dados) {
        return null;
    }

    public DadosDependente atualizar(UUID id, @Valid DadosDeAtualizacaoDependente dado) {
        return null;
    }

    public void delete(UUID id) {
    }
    
}
