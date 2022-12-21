package intraer.dirad.ApiControleDeAcesso.Dto;

import java.util.List;

import org.springframework.beans.BeanUtils;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import intraer.dirad.ApiControleDeAcesso.model.Contato;
import intraer.dirad.ApiControleDeAcesso.model.Dependente;
import intraer.dirad.ApiControleDeAcesso.model.Militar;
import intraer.dirad.ApiControleDeAcesso.model.Pessoa;
import intraer.dirad.ApiControleDeAcesso.model.secao;

public class PessoaDto {

    private String nome;
    private String cpf;
    private Contato contato;
    private String sexo;
    private List<secao> setor;
    private Militar militar;
    
    private List<Dependente> dependentes;

    public PessoaDto(Pessoa pessoa){
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.contato = pessoa.getContato();
        this.sexo = pessoa.getSexo();
        this.setor = pessoa.getSetor();
        this.militar = pessoa.getMilitar();
    }

    public static List<PessoaDto> ConverterPessoa(List<Pessoa> pessoas) {
        return pessoas.stream().map(PessoaDto::new).toList();
    }
    public static PessoaDto ConverterPessoa(Pessoa pessoa) {
    
        PessoaDto pessoaDto = new PessoaDto(pessoa);
        return pessoaDto;
    }

    
    
}
