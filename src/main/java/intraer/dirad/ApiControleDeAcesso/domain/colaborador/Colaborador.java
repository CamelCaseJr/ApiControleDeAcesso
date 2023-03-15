package intraer.dirad.ApiControleDeAcesso.domain.colaborador;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.empresa.Empresa;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "colaboradores")
@Data
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;

    
    @OneToOne
    private Pessoa pessoa;

    @OneToOne
    private Empresa empresa;
}
