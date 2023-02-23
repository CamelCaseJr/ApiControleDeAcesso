package intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar;

import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.validacoes.DadosAtualizacaoOrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.validacoes.DadosOrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OMRepository;
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
        var organMilitar = mapper.map(dado, OrganizacaoMilitar.class);
        organMilitar = repository.save(organMilitar);
        return mapper.map(organMilitar, DadosOrganizacaoMilitar.class);

    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
    
}
