package intraer.dirad.ApiControleDeAcesso.domain.gerente;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.PermissaoGerenteLocalAcesso;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "gerentes")
@Data

public class Gerente {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa Pessoa;

    @OneToMany
    private List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos = new ArrayList<>();



}
