package intraer.dirad.ApiControleDeAcesso.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;

    private String nome;
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "contato_id")
    private Contato contato;
    private String sexo;


    @OneToMany
    private List<secao> setor;



    @OneToOne( fetch = FetchType.LAZY)
    private Militar militar;
    
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Dependente> dependentes = new ArrayList<>();

}
