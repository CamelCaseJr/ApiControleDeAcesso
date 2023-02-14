package intraer.dirad.ApiControleDeAcesso.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosPessoa;
import intraer.dirad.ApiControleDeAcesso.facade.PessoaFacade;
import intraer.dirad.ApiControleDeAcesso.repository.ContatoRepository;
import intraer.dirad.ApiControleDeAcesso.repository.MilitarRepository;
import intraer.dirad.ApiControleDeAcesso.repository.SecaoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.repository.PessoaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ContatoRepository contatoRepository;
    private final SecaoRepository secaoRepository;
    private final ModelMapper mapper;
    private final MilitarRepository militarRepository;



    public List<DadosPessoa> findAll() {
        var pessoa = pessoaRepository.findAll();
        return DadosPessoa.toDadosPesso(pessoa);
    }

    public DadosPessoa findById(UUID id) {
        var pessoa = pessoaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrada"));
        return mapper.map(pessoa, DadosPessoa.class);
    }

    @Transactional
    public DadosPessoa salvar(DadosCadastroPessoa dados) {
        var pessoa = PessoaFacade.cria(pessoaRepository,
                contatoRepository,
                mapper,
                secaoRepository,
                militarRepository,
                dados );
        return mapper.map(pessoa, DadosPessoa.class);
    }


    public void delete(UUID id) {
        var pessoa = pessoaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrado"));
        pessoaRepository.delete(pessoa);
    }

    public DadosPessoa atualizar(UUID id, @Valid DadosCadastroPessoa dado) {
        pessoaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrada"));
        Pessoa pessoa = mapper.map(dado,Pessoa.class);
        pessoa.setId(id);
        pessoa = pessoaRepository.save(pessoa);
        return mapper.map(pessoa, DadosPessoa.class);

    }
    
}
