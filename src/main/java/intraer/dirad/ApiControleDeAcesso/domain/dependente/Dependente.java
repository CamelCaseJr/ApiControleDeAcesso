package intraer.dirad.ApiControleDeAcesso.domain.dependente;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.Responsavel;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dependentes")
@Data

public class Dependente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//@Column(columnDefinition = "varchar(36)")
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    private Pessoa pessoas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsavel_id")
    private Responsavel responsavel ;
    
}
