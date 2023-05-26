package intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.validacoes;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;
@Data
public class DadosCadastroOrganizacaoMilitar{
    String nome;
    @NotBlank
    String sigla;
}
