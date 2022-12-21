package intraer.dirad.ApiControleDeAcesso.model;

import java.util.ArrayList;
import java.util.UUID;

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

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Responsavel responsavel ;
    
}
