package intraer.dirad.ApiControleDeAcesso.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.enums.Permissoes;
import jakarta.persistence.Column;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "varchar(36)")
    private UUID id;
    
    private String nome;
    
    private secao secao;
    
    private List<DispositivoDeAcesso> dispositivosDeAcesso = new ArrayList<>();
    
    @OneToMany
    private List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos = new ArrayList<>();


}