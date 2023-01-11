package intraer.dirad.ApiControleDeAcesso.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.enums.Permissoes;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "permissoes_gerente_local")
@Data
public class PermissaoGerenteLocalAcesso {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//@Column(columnDefinition = "varchar(36)")
    private UUID id;

    @OneToOne
    private Gerente gerente ;
    @ManyToMany
    private List<PontoDeAcesso> localDeAcesso = new ArrayList<>();
    
    @Enumerated
    private List<Permissoes> permissoes = new ArrayList<>();
}
