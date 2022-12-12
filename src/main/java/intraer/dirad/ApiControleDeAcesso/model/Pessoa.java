package intraer.dirad.ApiControleDeAcesso.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pessoas")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "varchar(36)")
    private UUID id;

    private String nome;
    private String cpf;
    private Contato contato;
    private String sexo;
    private secao setor;



    @OneToOne( fetch = FetchType.LAZY, mappedBy = "militares")
    private Militar militar;
    
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Dependente> dependentes;

}
