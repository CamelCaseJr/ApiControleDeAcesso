package intraer.dirad.ApiControleDeAcesso.domain.empresa;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes.DadosCadastroEmpresa;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes.DadosEmpresa;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmpresaService {

    private final EmpresaRepository repository;
    private final ModelMapper mapper;

    public Page<DadosEmpresa> findAll(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosEmpresa::new);

    }

    public DadosEmpresa salvar(@Valid DadosCadastroEmpresa dados) {
        var empresa = mapper.map(dados, Empresa.class);
        repository.save(empresa);
        return mapper.map(empresa, DadosEmpresa.class);
    }

    public DadosEmpresa atualizar(UUID id, @Valid DadosCadastroEmpresa dado) {
        var empresa = mapper.map(dado,Empresa.class);
        empresa = repository.save(empresa);
        return mapper.map(empresa, DadosEmpresa.class);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public DadosEmpresa findById(UUID id) {
        var empresa = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("empresa not found"));
        return mapper.map(empresa, DadosEmpresa.class);
    }

}
