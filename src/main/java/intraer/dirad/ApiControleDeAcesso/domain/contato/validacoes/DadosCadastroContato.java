package intraer.dirad.ApiControleDeAcesso.domain.contato.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.enums.TipoContato;
import lombok.Data;

@Data
public class DadosCadastroContato {
    private TipoContato tipo;
    private String valorDoContato;
    
}
