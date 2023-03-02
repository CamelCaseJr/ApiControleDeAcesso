package intraer.dirad.ApiControleDeAcesso.domain.contato.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.enums.TipoContato;
import intraer.dirad.ApiControleDeAcesso.infra.validacoes.ValidarTelefone;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DadosCadastroContato {
    @NotBlank(message = "field cannot be empty")
    private TipoContato tipo;
    @ValidarTelefone()
    private String valorDoContato;
    
}
