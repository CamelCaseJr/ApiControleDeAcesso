package intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.PermissaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.DispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.secao.Secao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name= "locais_de_acesso")
@Data

public class PontoDeAcesso {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;
    
    private String nome;
    
    @OneToMany
    private List<Secao> secao = new ArrayList<>();

    @OneToMany
    private List<DispositivoDeAcesso> dispositivosDeAcesso = new ArrayList<>();
    
    @OneToMany
    private List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos = new ArrayList<>();


}
