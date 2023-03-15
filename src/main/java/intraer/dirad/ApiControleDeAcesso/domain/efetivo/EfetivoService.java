package intraer.dirad.ApiControleDeAcesso.domain.efetivo;

import intraer.dirad.ApiControleDeAcesso.domain.efetivo.validacoes.DadosCadastroEfetivo;
import intraer.dirad.ApiControleDeAcesso.domain.efetivo.validacoes.DadosEfetivo;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EfetivoService {

    private final EfetivoRepository repository;
    private final ModelMapper mapper;

    public Page<DadosEfetivo> findAll(Pageable paginacao) {
        return   repository.findAll(paginacao).map(DadosEfetivo::new);

    }

    public DadosEfetivo findById(UUID id) {
        return repository.findById(id).map(DadosEfetivo::new)
                .orElseThrow(()-> new EntityNotFoundException("não encontrado"));
    }

    public DadosEfetivo salvar(DadosCadastroEfetivo dados) {
        Efetivo efetivo = mapper.map(dados, Efetivo.class);
        var finalEfetivo = efetivo;
        efetivo = repository.findByOrganizacaoMilitarNome(dados.getOrganizacaoMilitar().getNome())
                .orElseGet(()-> repository.save(finalEfetivo));

        return mapper.map(efetivo, DadosEfetivo.class);
    }

    public DadosEfetivo atualizar(UUID id, DadosCadastroEfetivo dado) {

        Efetivo efetivo = mapper.map(dado, Efetivo.class);
        efetivo.setId(id);
        repository.save(efetivo);
        return new DadosEfetivo(efetivo);
    }

    public void delete(UUID id) {
    }
}
