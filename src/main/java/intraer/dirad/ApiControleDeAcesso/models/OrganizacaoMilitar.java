package intraer.dirad.ApiControleDeAcesso.models;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "organizacoes_militares")
@Data

public class OrganizacaoMilitar {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//@Column(columnDefinition = "varchar(36)")
    private UUID id;

    private String nome;
    private String sigla;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Secao> secao;
    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "organizacoes_subordinada")
    private List<OrganizacaoMilitar> organizacoesSubordinadas;

}
