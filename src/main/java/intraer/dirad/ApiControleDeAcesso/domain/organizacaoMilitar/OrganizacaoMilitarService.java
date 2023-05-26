package intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar;

import intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes.DadosCadastroMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.validacoes.DadosAtualizacaoOrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.validacoes.DadosCadastroOrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.validacoes.DadosOrganizacaoMilitar;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrganizacaoMilitarService {
    private final OMRepository repository;
    private final ModelMapper mapper;

    public Page<DadosOrganizacaoMilitar> findAll(Pageable paginacao) {
       return  repository.findAll(paginacao).map(DadosOrganizacaoMilitar::new);

    }

    public DadosOrganizacaoMilitar findById(UUID id) {
        var organMilitar = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("OM não encontrada"));
        return mapper.map(organMilitar, DadosOrganizacaoMilitar.class);
    }

    public DadosOrganizacaoMilitar salvar(@Valid DadosCadastroOrganizacaoMilitar dados) {
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
