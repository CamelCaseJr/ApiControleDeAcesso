package intraer.dirad.ApiControleDeAcesso.Dtos.DtoOrganizacaoMilitar;

import java.util.UUID;

public record DadosOrganizacaoMilitar(
    UUID id,
    String nome,
    String sigla

) {
    
}
