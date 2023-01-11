package intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import intraer.dirad.ApiControleDeAcesso.models.Contato;
import intraer.dirad.ApiControleDeAcesso.models.Dependente;
import intraer.dirad.ApiControleDeAcesso.models.Militar;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.models.Secao;

public class DadosPessoa {

    private UUID id;
    private String nome;
    private String cpf;
    private Contato contato;
    private String sexo;
    private List<Secao> setor;
    private Militar militar;
    
    private List<Dependente> dependentes;

    public DadosPessoa(Pessoa pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.contato = pessoa.getContato();
        this.sexo = pessoa.getSexo();
        this.setor = pessoa.getSetor();
        this.militar = pessoa.getMilitar();
    }

    public static List<DadosPessoa> ConverterPessoa(List<Pessoa> pessoas) {
        return pessoas.stream().map(DadosPessoa::new).toList();
    }
    public static DadosPessoa ConverterPessoa(Pessoa pessoa) {
    
        DadosPessoa pessoaDto = new DadosPessoa(pessoa);
        return pessoaDto;
    }

    
    
}
