package intraer.dirad.ApiControleDeAcesso.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosPessoa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.facade.PessoaFacade;
import intraer.dirad.ApiControleDeAcesso.models.Militar;
import intraer.dirad.ApiControleDeAcesso.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PessoaService {

    private final RepositorioGlobal repository;
    private final ModelMapper mapper;
    private final PessoaFacade pessoaFacade;




    public List<DadosPessoa> findAll() {
        var pessoa = repository.getPessoaRepository().findAll();
        return DadosPessoa.toDadosPesso(pessoa);
    }

    public DadosPessoa findById(UUID id) {
        var pessoa = repository.getPessoaRepository().findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrada"));
        return mapper.map(pessoa, DadosPessoa.class);
    }

    @Transactional
    public DadosPessoa salvar(DadosCadastroPessoa dados) {
        var pessoa = mapper.map(dados, Pessoa.class);
        repository.getPessoaRepository().save(pessoa);
        return mapper.map(pessoa, DadosPessoa.class);
    }
    @Transactional
    public DadosPessoa salvarpessoaFacade(DadosCadastroPessoa dados) {
        var pessoa = pessoaFacade.cria(dados);
        return mapper.map(pessoa, DadosPessoa.class);
    }


    public void delete(UUID id) {
        var pessoa = repository.getPessoaRepository().findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrado"));
        repository.getPessoaRepository().delete(pessoa);
    }

    public DadosPessoa atualizar(UUID id, @Valid DadosCadastroPessoa dado) {
        repository.getPessoaRepository().findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrada"));
        Pessoa pessoa = mapper.map(dado,Pessoa.class);
        pessoa.setId(id);
        pessoa = repository.getPessoaRepository().save(pessoa);
        return mapper.map(pessoa, DadosPessoa.class);

    }

    public DadosPessoa salvarContatos(UUID id, DadosCadastroPessoa dado) {
        var pessoa = repository.getPessoaRepository().findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrado"));

        var valorDoContato = dado.getContato().getValorDoContato();
        var tipo = dado.getContato().getTipo();

        if (!valorDoContato.isBlank() && tipo != null){
            var contato = repository.getContatoRepository().save(dado.getContato());
            pessoa.setContato(contato);
            repository.getPessoaRepository().save(pessoa);
            return mapper.map(pessoa, DadosPessoa.class);
        }else throw new EntityNotFoundException("Contato está em branco");

    }

    public DadosPessoa salvarMilitar(UUID id, DadosCadastroPessoa dados) {
        var pessoa = repository.getPessoaRepository().findById(id)
                .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrado"));

        if (dados.getMilitar() != null) {
            var militar = mapper.map(dados.getMilitar(), Militar.class);
            militar.setPessoa(pessoa);
            var militarsalvo = repository.getMilitarRepository().save(militar);
            pessoa.setMilitar(militarsalvo);
            var pessoaSalva = repository.getPessoaRepository().save(pessoa);
            return mapper.map(pessoaSalva, DadosPessoa.class);
        } else {
            return mapper.map(pessoa,DadosPessoa.class);
        }
    }


    public DadosPessoa criarSecao(UUID id, DadosCadastroPessoa dado) {
        if (dado.getSetor() != null) {
            var pessoa = repository.getPessoaRepository().findById(id)
                    .orElseThrow(()-> new EntityNotFoundException("pessoa não encontrado"));
            var setor = dado.getSetor().stream()
                    .map(repository.getSecaoRepository()::save).toList();
            pessoa.setSetor(setor);
            val save = repository.getPessoaRepository().save(pessoa);
            return mapper.map(save, DadosPessoa.class);
        }else throw new EntityNotFoundException("Secao nao pode ser nula");
    }
}
