package intraer.dirad.ApiControleDeAcesso.domain.contato.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.enums.TipoContato;
import intraer.dirad.ApiControleDeAcesso.infra.validacoes.ValidarTelefone;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;
@Data
public class DadosAtualizacaoContato {
    private TipoContato tipo;

    @ValidarTelefone
    private String valorDoContato;
    
}
