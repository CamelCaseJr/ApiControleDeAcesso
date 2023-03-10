package intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.models.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import lombok.Data;

@Data
public class DadosMilitar{
    private UUID id;
    private String saram;
    private Pessoa pessoa;
    private String nomeDeGuerra;
    private OrganizacaoMilitar om;
    private String posto;
    
}
