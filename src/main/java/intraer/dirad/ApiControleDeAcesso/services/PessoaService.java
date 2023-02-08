package intraer.dirad.ApiControleDeAcesso.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosPessoa;
import intraer.dirad.ApiControleDeAcesso.models.Secao;
import intraer.dirad.ApiControleDeAcesso.repository.ContatoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.repository.PessoaRepository;

@Service
public class PessoaService {

    private final PessoaRepository repository;
    private final ContatoRepository contatoRepository;
    private final ModelMapper mapper;

    public PessoaService(PessoaRepository repository, ContatoRepository contatoRepository, ModelMapper mapper) {
        this.repository = repository;
        this.contatoRepository = contatoRepository;
        this.mapper = mapper;
    }

    public List<DadosPessoa> findAll() {
        var pessoa = repository.findAll();
        return pessoa.stream()
                .map(p-> mapper.map(p, DadosPessoa.class))
                .collect(Collectors.toList());
    }

    public DadosPessoa findById(UUID id) {
        var pessoa = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrada"));
        return mapper.map(pessoa, DadosPessoa.class);
    }

    public DadosPessoa salvar(DadosCadastroPessoa dados) {
        var pessoa = mapper.map(dados, Pessoa.class);
        var contato = contatoRepository.save(dados.getContato());
        pessoa.setContato(contato);

        repository.save(pessoa);
        return mapper.map(pessoa, DadosPessoa.class);
    }

    public void delete(UUID id) {
        var pessoa = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrado"));
        repository.delete(pessoa);
    }

    public DadosPessoa atualizar(UUID id, @Valid DadosCadastroPessoa dado) {
        repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrada"));
        Pessoa pessoa = mapper.map(dado,Pessoa.class);
        pessoa.setId(id);
        pessoa = repository.save(pessoa);
        return mapper.map(pessoa, DadosPessoa.class);

    }
    
}
