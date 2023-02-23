package intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.validacoes.DadosAtualizacaoDispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.validacoes.DadosCadastroDispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.validacoes.DadosDispositivosDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.DispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.DispositivoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DispositivoDeAcessoService {
    private final DispositivoRepository repository;
    private final ModelMapper mapper;

    public List<DadosDispositivosDeAcesso> findAll() {
        var dispositivoDeAcessos = repository.findAll();
        return dispositivoDeAcessos.stream()
        .map(d-> mapper.map(d, DadosDispositivosDeAcesso.class))
        .collect(Collectors.toList());
        
    }

    public DadosDispositivosDeAcesso findById(UUID id) {
        DispositivoDeAcesso dispositivo = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Dispositivo não encontrado"));
        return mapper.map(dispositivo, DadosDispositivosDeAcesso.class);
    }

    public DadosDispositivosDeAcesso salvar(@Valid DadosCadastroDispositivoDeAcesso dados) {
        DispositivoDeAcesso dispositivo = mapper.map(dados, DispositivoDeAcesso.class);
        dispositivo = repository.save(dispositivo);
        return mapper.map(dispositivo, DadosDispositivosDeAcesso.class);
    }
    public DadosDispositivosDeAcesso atualizar(UUID id, @Valid DadosAtualizacaoDispositivoDeAcesso dados) {
        var dispositivo = mapper.map(dados, DispositivoDeAcesso.class);
        dispositivo =repository.save(dispositivo);
        return mapper.map(dispositivo, DadosDispositivosDeAcesso.class);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
    
}
