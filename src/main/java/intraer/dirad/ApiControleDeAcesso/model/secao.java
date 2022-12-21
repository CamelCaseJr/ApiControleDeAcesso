package intraer.dirad.ApiControleDeAcesso.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class secao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;
    
    private String nome;
    private String sigla;
    @ManyToMany
    private List<Responsavel> responsaveis = new ArrayList<>();

    @OneToMany
    private List<Efetivo> efetivo = new ArrayList<>();

}
