package intraer.dirad.ApiControleDeAcesso.services;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosPessoa;
import intraer.dirad.ApiControleDeAcesso.facade.PessoaFacade;
import intraer.dirad.ApiControleDeAcesso.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PessoaService {

    private final PessoaFacade pessoaFacade;
    private final RepositorioGlobal repositorioGlobal;
    private final ModelMapper mapper;




    public List<DadosPessoa> findAll() {
        var pessoa = repositorioGlobal.getPessoaRepository().findAll();
        return DadosPessoa.toDadosPesso(pessoa);
    }

    public DadosPessoa findById(UUID id) {
        var pessoa = repositorioGlobal.getPessoaRepository().findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrada"));
        return mapper.map(pessoa, DadosPessoa.class);
    }

    @Transactional
    public DadosPessoa salvar(DadosCadastroPessoa dados) {
        var pessoa = pessoaFacade.cria(dados);
        return mapper.map(pessoa, DadosPessoa.class);
    }


    public void delete(UUID id) {
        var pessoa = repositorioGlobal.getPessoaRepository().findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrado"));
        repositorioGlobal.getPessoaRepository().delete(pessoa);
    }

    public DadosPessoa atualizar(UUID id, @Valid DadosCadastroPessoa dado) {
        repositorioGlobal.getPessoaRepository().findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrada"));
        Pessoa pessoa = mapper.map(dado,Pessoa.class);
        pessoa.setId(id);
        pessoa = repositorioGlobal.getPessoaRepository().save(pessoa);
        return mapper.map(pessoa, DadosPessoa.class);

    }
    
}
