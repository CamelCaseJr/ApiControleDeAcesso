package intraer.dirad.ApiControleDeAcesso.Dtos.DtoOrganizacaoMilitar;

import java.util.UUID;

public record DadosAtualizacaoOrganizacaoMilitar(
    UUID id,

    String nome,
    String sigla

) {
    
}
