package intraer.dirad.ApiControleDeAcesso.services;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoOrganizacaoMilitar.DadosAtualizacaoOrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoOrganizacaoMilitar.DadosOrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.models.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.repository.OMRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrganizacaoMilitarService {
    private final OMRepository repository;
    private final ModelMapper mapper;

    public List<DadosOrganizacaoMilitar> findAll() {
       var OM = repository.findAll();
       return OM.stream()
               .map(om -> mapper.map(om, DadosOrganizacaoMilitar.class))
               .collect(Collectors.toList());
    }

    public DadosOrganizacaoMilitar findById(UUID id) {
        var organMilitar = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("OM não encontrada"));
        return mapper.map(organMilitar, DadosOrganizacaoMilitar.class);
    }

    public DadosOrganizacaoMilitar salvar(@Valid DadosCadastroMilitar dados) {
        var organMilitar = mapper.map(dados, OrganizacaoMilitar.class);
        repository.save(organMilitar);
        return mapper.map(organMilitar, DadosOrganizacaoMilitar.class);
    }

    public DadosOrganizacaoMilitar atualizar(UUID id, @Valid DadosAtualizacaoOrganizacaoMilitar dado) {
        var organMilitar = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("organizacao não encontrada"));
        mapper.map(dado, organMilitar);
        repository.save(organMilitar);
        return mapper.map(organMilitar, DadosOrganizacaoMilitar.class);

    }

    public void delete(UUID id) {
        var organMilitar = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("organizacao não encontrado"));
        repository.delete(organMilitar);
    }
    
}
