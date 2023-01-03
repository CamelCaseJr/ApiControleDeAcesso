package intraer.dirad.ApiControleDeAcesso.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import intraer.dirad.ApiControleDeAcesso.Dto.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.model.Pessoa;
import intraer.dirad.ApiControleDeAcesso.repository.PessoaRepository;
import jakarta.validation.Valid;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(UUID id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa salvar(DadosCadastroPessoa pessoaForm) {
        var pessoa = new Pessoa();

        BeanUtils.copyProperties(pessoaForm, pessoa);
        return pessoaRepository.save(pessoa);
    }

    public String deletar(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
        return pessoa.getNome()+"removido(a) com sucesso!";
    }

    public Pessoa getReferenceById(UUID pessoaid) {
        return pessoaRepository.getReferenceById(pessoaid);
    }
    
}
