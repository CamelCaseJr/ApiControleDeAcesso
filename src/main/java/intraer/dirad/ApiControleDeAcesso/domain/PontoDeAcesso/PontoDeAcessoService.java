package intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.validacoes.DadosAtualizacaoPontoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.validacoes.DadosCadastroPontoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.validacoes.DadosPontoDeAcesso;
import jakarta.validation.Valid;

@Service
@AllArgsConstructor
public class PontoDeAcessoService {
    private final PontoDeAcessoRepository repository;
    private final ModelMapper mapper;

    public Page<DadosPontoDeAcesso> findAll(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosPontoDeAcesso::new);
    }

    public DadosPontoDeAcesso findById(UUID id) {
        var pontoDeAcesso = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pontoDeAcesso não encontrada"));
        return mapper.map(pontoDeAcesso, DadosPontoDeAcesso.class);
    }

    public DadosPontoDeAcesso salvar(@Valid DadosCadastroPontoDeAcesso dados) {
        var pontoDeAcesso = mapper.map(dados, PontoDeAcesso.class);
        repository.save(pontoDeAcesso);
        return mapper.map(pontoDeAcesso, DadosPontoDeAcesso.class);
    }

    public DadosPontoDeAcesso atualizar(UUID id, @Valid DadosAtualizacaoPontoDeAcesso dado) {
        var pontoDeAcesso = mapper.map(dado, PontoDeAcesso.class);
        pontoDeAcesso.setId(id);
        repository.save(pontoDeAcesso);
        return mapper.map(pontoDeAcesso, DadosPontoDeAcesso.class);
    }

    public void delete(UUID id) {

        repository.deleteById(id);
    }
    
}
