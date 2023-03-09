package intraer.dirad.ApiControleDeAcesso.domain.efetivo;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Efetivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//@Column(columnDefinition = "varchar(36)")
    private UUID id;
    @OneToOne()
    private OrganizacaoMilitar organizacaoMilitar;

    @OneToMany
    @JoinColumn(name = "pessoa_id")
    private List<Pessoa> pessoa;
}
