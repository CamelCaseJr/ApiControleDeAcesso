package intraer.dirad.ApiControleDeAcesso.domain.pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import intraer.dirad.ApiControleDeAcesso.domain.colaborador.Colaborador;
import intraer.dirad.ApiControleDeAcesso.domain.contato.Contato;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.Dependente;
import intraer.dirad.ApiControleDeAcesso.domain.militar.Militar;
import intraer.dirad.ApiControleDeAcesso.domain.secao.Secao;
import jakarta.persistence.*;
import lombok.Data;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Data

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;

    private String nome;
    private String cpf;
    @ManyToOne()
    private Contato contato;
    @OneToOne()
    private Colaborador colaborador;
    private String sexo;
    @OneToMany()
    private List<Secao> setor;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Militar militar;
    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Dependente> dependentes = new ArrayList<>();

    public void setMilitar(Militar militar) {
        this.militar = militar;
        militar.setPessoa(this);
    }
}
