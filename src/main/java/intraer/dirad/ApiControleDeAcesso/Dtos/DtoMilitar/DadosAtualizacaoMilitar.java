package intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar;

import intraer.dirad.ApiControleDeAcesso.models.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;

public record DadosAtualizacaoMilitar(
    String saram,
    Pessoa pessoa,
    String nomeDeGuerra,
    OrganizacaoMilitar om,
    String posto
) {
    
}
