package intraer.dirad.ApiControleDeAcesso.Dtos.DtoOrganizacaoMilitar;

import lombok.Data;

import java.util.UUID;
@Data
public class DadosCadastroOrganizacaoMilitar{
    UUID id;
    String nome;
    String sigla;
}
