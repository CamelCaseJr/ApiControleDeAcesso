package intraer.dirad.ApiControleDeAcesso.models;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "militares")
@Data

public class Militar  {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//@Column(columnDefinition = "varchar(36)")
    private UUID id;
    
    private String saram;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    @JsonIgnore
    private Pessoa pessoa;

    private String nomeDeGuerra;
    @OneToOne
    @JoinColumn(name = "om_id")
    private OrganizacaoMilitar om;
    private String posto;
    





}
