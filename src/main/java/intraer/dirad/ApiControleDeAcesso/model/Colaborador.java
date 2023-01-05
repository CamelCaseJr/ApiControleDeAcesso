package intraer.dirad.ApiControleDeAcesso.model;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosPessoa;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "colaboradores")
@Data
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;

    
    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @OneToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
