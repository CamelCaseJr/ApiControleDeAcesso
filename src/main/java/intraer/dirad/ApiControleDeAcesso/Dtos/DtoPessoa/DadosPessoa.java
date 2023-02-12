package intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosContato;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import intraer.dirad.ApiControleDeAcesso.models.Contato;
import intraer.dirad.ApiControleDeAcesso.models.Dependente;
import intraer.dirad.ApiControleDeAcesso.models.Militar;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.models.Secao;

@Data
public class DadosPessoa  {


    private UUID id;
    private String nome;
    private String cpf;

    private Contato contato;
    private String sexo;
    private List<Secao> setor;
    private Militar militar;
    @JsonIgnore
    private List<Dependente> dependentes = new ArrayList<>();

    public DadosPessoa(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.contato = pessoa.getContato();
        this.sexo = pessoa.getSexo();
        this.setor = pessoa.getSetor();
        this.militar = pessoa.getMilitar();
        this.dependentes = pessoa.getDependentes();
    }

    public DadosPessoa() {
    }

    public static List<DadosPessoa> toDadosPesso(List<Pessoa> pessoa){
        return pessoa.stream().map(DadosPessoa::new).collect(Collectors.toList());
    }
}
