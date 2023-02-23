package intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.validacoes;

import lombok.Data;

import java.util.UUID;
@Data
public class DadosAtualizacaoOrganizacaoMilitar {
    UUID id;
    String nome;
    String sigla;
    
}
