package intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import intraer.dirad.ApiControleDeAcesso.domain.efetivo.Efetivo;
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

    @OneToOne
    private Efetivo efetivo;

}
