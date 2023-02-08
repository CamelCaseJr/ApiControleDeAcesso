package intraer.dirad.ApiControleDeAcesso.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Secao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;
    
    private String nome;
    private String sigla;
    @ManyToMany
    private List<Responsavel> responsaveis = new ArrayList<>();

    @OneToMany
    private List<Pessoa> pessoas = new ArrayList<>();

    public void setPessoas(Pessoa pessoa){
        pessoas.add(pessoa);
    }

}
