package intraer.dirad.ApiControleDeAcesso.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "empresas")
@Data

public class Empresa {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//@Column(columnDefinition = "varchar(36)")
    private UUID id;

    private String nome;
    private String cnpj;
    @OneToOne
    @JoinColumn(name = "contato_id")
    private Contato contato;
    @OneToMany
    private List<Endereco> endereco = new ArrayList();
    
}
