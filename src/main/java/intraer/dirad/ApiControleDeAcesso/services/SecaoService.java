package intraer.dirad.ApiControleDeAcesso.services;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosAtualizacaoContato;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosCadastroContato;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosContato;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoSecao.DadosAtualizacaoSecao;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoSecao.DadosCadastroSecao;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoSecao.DadosSecao;
import intraer.dirad.ApiControleDeAcesso.models.Contato;
import intraer.dirad.ApiControleDeAcesso.models.Secao;
import intraer.dirad.ApiControleDeAcesso.repository.ContatoRepository;
import intraer.dirad.ApiControleDeAcesso.repository.SecaoRepository;
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
public class SecaoService {
    private final SecaoRepository repository;
    private final ModelMapper mapper;

    public List<DadosSecao>findAll() {
        var secoes = repository.findAll();
        return secoes.stream()
                .map(c-> mapper.map(c, DadosSecao.class))
                .collect(Collectors.toList());
    }

    public DadosSecao salvar(@Valid DadosCadastroSecao dados) {
        var secao = mapper.map(dados, Secao.class);
        repository.save(secao);
        return mapper.map(secao, DadosSecao.class);
    }

    public DadosSecao atualizar(UUID id, @Valid DadosAtualizacaoSecao dado) {
        var secao = mapper.map(dado,Secao.class);
        secao = repository.save(secao);
        return mapper.map(secao, DadosSecao.class);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public DadosSecao findById(UUID id) {
        var secao = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("secao not found"));
        return mapper.map(secao, DadosSecao.class);
    }
    
}
