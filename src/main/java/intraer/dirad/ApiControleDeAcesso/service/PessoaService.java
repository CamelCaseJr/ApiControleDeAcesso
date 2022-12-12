package intraer.dirad.ApiControleDeAcesso.service;

import java.util.List;

import intraer.dirad.ApiControleDeAcesso.model.Pessoa;
import intraer.dirad.ApiControleDeAcesso.repository.PessoaRepository;

public class PessoaService {

    PessoaRepository pessoaRepository;


    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }


    public  List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }
    
}
