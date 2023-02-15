package intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar;

import intraer.dirad.ApiControleDeAcesso.models.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import lombok.Data;

import java.util.UUID;
@Data
public class DadosAtualizacaoMilitar{
    private UUID id;
    private String saram;
    private Pessoa pessoa;
    private String nomeDeGuerra;
    private OrganizacaoMilitar om;
    private String posto;
    
}
