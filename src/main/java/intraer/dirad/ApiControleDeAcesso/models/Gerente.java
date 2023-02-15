package intraer.dirad.ApiControleDeAcesso.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private Pessoa Pessoa;

    @OneToMany
    private List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos = new ArrayList<>();



}
