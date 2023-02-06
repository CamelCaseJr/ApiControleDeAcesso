package intraer.dirad.ApiControleDeAcesso.services;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import intraer.dirad.ApiControleDeAcesso.mappers.ColaboradorMapper;
import intraer.dirad.ApiControleDeAcesso.repository.ColaboradorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador.DadosAtualizacaoColaborador;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador.DadosCadastroColaborador;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador.DadosColaborador;
import intraer.dirad.ApiControleDeAcesso.models.Colaborador;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import jakarta.validation.Valid;

@Service
@AllArgsConstructor
public class ColaboradorService {
    private final ColaboradorRepository repository;
    private final ModelMapper mapper;
    private final ColaboradorMapper cMapper;

    public List<DadosColaborador> findAll() {
        var colaboradores = repository.findAll();
        return colaboradores.stream()
                .map(c-> mapper.map(c, DadosColaborador.class))
                .collect(Collectors.toList());
    }

    public DadosColaborador salvar(@Valid DadosCadastroColaborador dado) {
        Colaborador colaborador = mapper.map(dado, Colaborador.class);
        repository.save(colaborador);
        return mapper.map(colaborador, DadosColaborador.class);

    }

    public DadosColaborador getReferenceById(UUID id) {
        return null;
    }

    public DadosColaborador atualizar(UUID id, @Valid DadosAtualizacaoColaborador dado) {
        try {
            var colaboradorOpitinal = repository.findById(id);
            Colaborador colaborador = colaboradorOpitinal
                    .orElseThrow(() -> new EntityNotFoundException("People not found"));
            repository.save(colaborador);
            return mapper.map(colaborador, DadosColaborador.class);
        }catch (EntityNotFoundException err){
            throw new EntityNotFoundException(err.getMessage());
        }

    }

    public void delete(UUID id) {
        var colaboradorOpitinal = repository.findById(id);
        Colaborador entity = colaboradorOpitinal
                .orElseThrow(() -> new EntityNotFoundException("People not found"));
        repository.delete(entity);
    }

    public DadosColaborador findById(UUID id) {
        var colaboradorOpitinal = repository.findById(id);
        Colaborador entity = colaboradorOpitinal
                .orElseThrow(() -> new EntityNotFoundException("People not found"));
        return mapper.map(entity, DadosColaborador.class);
    }

}
