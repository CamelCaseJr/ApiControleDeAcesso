package intraer.dirad.ApiControleDeAcesso.domain.endereco;

import intraer.dirad.ApiControleDeAcesso.domain.endereco.validacoes.DadosCadastroEndereco;
import intraer.dirad.ApiControleDeAcesso.domain.endereco.validacoes.DadosEndereco;
import intraer.dirad.ApiControleDeAcesso.domain.endereco.Endereco;
import intraer.dirad.ApiControleDeAcesso.domain.endereco.EnderecoRepository;
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
public class EnderecoService {
    private final EnderecoRepository repository;
    private final ModelMapper mapper;

    public List<DadosEndereco>findAll() {
        var enderecos = repository.findAll();
        return enderecos.stream()
                .map(c-> mapper.map(c, DadosEndereco.class))
                .collect(Collectors.toList());
    }

    public DadosEndereco salvar(@Valid DadosCadastroEndereco dados) {
        var endereco = mapper.map(dados, Endereco.class);
        repository.save(endereco);
        return mapper.map(endereco, DadosEndereco.class);
    }

    public DadosEndereco atualizar(UUID id, @Valid DadosCadastroEndereco dado) {
        var endereco = mapper.map(dado,Endereco.class);
        endereco = repository.save(endereco);
        return mapper.map(endereco, DadosEndereco.class);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public DadosEndereco findById(UUID id) {
        var endereco = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("endereço not found"));
        return mapper.map(endereco, DadosEndereco.class);
    }
    
}
