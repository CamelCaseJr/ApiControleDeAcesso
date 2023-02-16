package intraer.dirad.ApiControleDeAcesso.Dtos.DtoEmpresa;

import intraer.dirad.ApiControleDeAcesso.models.Contato;
import intraer.dirad.ApiControleDeAcesso.models.Endereco;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class DadosEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//@Column(columnDefinition = "varchar(36)")
    private UUID id;
    private String nome;
    private String cnpj;
    private Contato contato;
    private List<Endereco> endereco = new ArrayList();

}
