package intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
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
