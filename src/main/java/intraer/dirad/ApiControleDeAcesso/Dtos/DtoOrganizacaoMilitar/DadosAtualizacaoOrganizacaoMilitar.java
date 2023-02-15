package intraer.dirad.ApiControleDeAcesso.Dtos.DtoOrganizacaoMilitar;

import lombok.Data;

import java.util.UUID;
@Data
public class DadosAtualizacaoOrganizacaoMilitar {
    UUID id;
    String nome;
    String sigla;
    
}
