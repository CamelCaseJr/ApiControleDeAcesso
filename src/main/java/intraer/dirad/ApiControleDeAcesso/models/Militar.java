package intraer.dirad.ApiControleDeAcesso.models;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "militares")
@Data
public class Militar {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//@Column(columnDefinition = "varchar(36)")
    private UUID id;
    
    private String saram;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    private String nomeDeGuerra;
    @OneToOne
    @JoinColumn(name = "om_id")
    private OrganizacaoMilitar om;
    private String posto;
    





}
