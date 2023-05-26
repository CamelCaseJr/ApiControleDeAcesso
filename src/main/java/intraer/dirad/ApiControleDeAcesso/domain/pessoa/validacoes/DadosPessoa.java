package intraer.dirad.ApiControleDeAcesso.domain.pessoa.validacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import intraer.dirad.ApiControleDeAcesso.domain.colaborador.Colaborador;
import lombok.AllArgsConstructor;
import lombok.Data;

import intraer.dirad.ApiControleDeAcesso.domain.contato.Contato;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.Dependente;
import intraer.dirad.ApiControleDeAcesso.domain.militar.Militar;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.secao.Secao;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosPessoa  {


    private UUID id;
    private String nome;
    private String cpf;

    private Contato contato;
    private Colaborador colaborador;
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
        this.colaborador = pessoa.getColaborador();
    }

    public static Pessoa convertPessoa(DadosPessoa dadosPessoa){
        var pessoa = new Pessoa();
        pessoa.setId(dadosPessoa.getId());
        pessoa.setNome(dadosPessoa.getNome());
        pessoa.setCpf(dadosPessoa.getCpf());
        pessoa.setColaborador(dadosPessoa.getColaborador());
        pessoa.setContato(dadosPessoa.getContato());
        pessoa.setSexo(dadosPessoa.getSexo());
        pessoa.setSetor(dadosPessoa.getSetor());
        pessoa.setDependentes(dadosPessoa.getDependentes());
        return pessoa;
    }

}
