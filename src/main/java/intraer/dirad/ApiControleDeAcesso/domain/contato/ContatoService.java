package intraer.dirad.ApiControleDeAcesso.domain.contato;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.domain.contato.validacoes.DadosAtualizacaoContato;
import intraer.dirad.ApiControleDeAcesso.domain.contato.validacoes.DadosCadastroContato;
import intraer.dirad.ApiControleDeAcesso.domain.contato.validacoes.DadosContato;
import jakarta.validation.Valid;

@Service
@AllArgsConstructor
public class ContatoService {
    private final ContatoRepository repository;
    private final ModelMapper mapper;

    public Page<DadosContato> findAll(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosContato::new);
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
