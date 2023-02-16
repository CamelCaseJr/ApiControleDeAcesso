package intraer.dirad.ApiControleDeAcesso.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoVisita.DadosCadastroVisita;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoVisita.DadosVisita;
import intraer.dirad.ApiControleDeAcesso.models.Visita;
import intraer.dirad.ApiControleDeAcesso.repository.RepositorioGlobal;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VisitaService {

    private final RepositorioGlobal repository;
    private final ModelMapper mapper;
    



    public List<DadosVisita> findAll() {
        var visitas = repository.getVisitaRepository().findAll();
        return visitas.stream().map(v-> mapper.map(v, DadosVisita.class)).collect(Collectors.toList());
    }

    public DadosVisita findById(UUID id) {
        var visita = getVisitante(id, "visitante não encontrada");
        return mapper.map(visita, DadosVisita.class);
    }

    private Visita getVisitante(UUID id, String visitante_nao_encontrada) {
        return repository.getVisitaRepository().findById(id)
                .orElseThrow(() -> new EntityNotFoundException(visitante_nao_encontrada));
    }

    @Transactional
    public DadosVisita salvar(DadosCadastroVisita dados) {
        var visita = mapper.map(dados, Visita.class);
        repository.getVisitaRepository().save(visita);
        return mapper.map(visita, DadosVisita.class);
    }

    public void delete(UUID id) {
        repository.getVisitaRepository().deleteById(id);
    }

    public DadosVisita atualizar(UUID id, @Valid DadosCadastroVisita dado) {
        Visita visita = mapper.map(dado,Visita.class);
        visita.setId(id);
        visita = repository.getVisitaRepository().save(visita);
        return mapper.map(visita, DadosVisita.class);

    }


}

    
