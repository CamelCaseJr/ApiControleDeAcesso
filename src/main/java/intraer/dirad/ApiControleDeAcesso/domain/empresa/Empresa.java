package intraer.dirad.ApiControleDeAcesso.domain.empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.contato.Contato;
import intraer.dirad.ApiControleDeAcesso.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empresas")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
