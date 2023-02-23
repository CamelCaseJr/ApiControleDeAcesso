package intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
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
