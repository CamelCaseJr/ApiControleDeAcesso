package intraer.dirad.ApiControleDeAcesso.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import intraer.dirad.ApiControleDeAcesso.models.Contato;
import intraer.dirad.ApiControleDeAcesso.repository.ContatoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosAtualizacaoContato;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosCadastroContato;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosContato;
import jakarta.validation.Valid;

@Service
@AllArgsConstructor
public class ContatoService {
    private final ContatoRepository repository;
    private final ModelMapper mapper;

    public List<DadosContato>findAll() {
        var contatos = repository.findAll();
        return contatos.stream()
                .map(c-> mapper.map(c, DadosContato.class))
                .collect(Collectors.toList());
    }

    public DadosContato salvar(@Valid DadosCadastroContato dados) {
        Contato contato = mapper.map(dados, Contato.class);
        repository.save(contato);
        return mapper.map(contato, DadosContato.class);
    }

    public DadosContato atualizar(UUID id, @Valid DadosAtualizacaoContato dado) {
        var contato = mapper.map(dado,Contato.class);
        contato = repository.save(contato);
        return mapper.map(contato, DadosContato.class);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public DadosContato findById(UUID id) {
        Contato contato = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("contato not found"));
        return mapper.map(contato, DadosContato.class);
    }
    
}
