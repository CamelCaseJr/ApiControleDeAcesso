package intraer.dirad.ApiControleDeAcesso.domain.empresa;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes.DadosCadastroEmpresa;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes.DadosEmpresa;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.Empresa;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.EmpresaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmpresaService {

    private final EmpresaRepository repository;
    private final ModelMapper mapper;

    public List<DadosEmpresa> findAll() {
        var empresas = repository.findAll();
        return empresas.stream()
                .map(c-> mapper.map(c, DadosEmpresa.class))
                .collect(Collectors.toList());
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
