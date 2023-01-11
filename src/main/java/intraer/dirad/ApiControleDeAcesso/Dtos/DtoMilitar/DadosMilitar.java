package intraer.dirad.ApiControleDeAcesso.Dtos.DtoMilitar;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.models.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;

public record DadosMilitar(
    UUID id,
    String saram,
    Pessoa pessoa,
    String nomeDeGuerra,
    OrganizacaoMilitar om,
    String posto
) {
    
}
