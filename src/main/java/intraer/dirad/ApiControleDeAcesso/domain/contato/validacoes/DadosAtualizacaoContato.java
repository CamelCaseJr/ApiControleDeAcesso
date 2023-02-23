package intraer.dirad.ApiControleDeAcesso.domain.contato.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.enums.TipoContato;
import lombok.Data;

import java.util.UUID;
@Data
public class DadosAtualizacaoContato {
    private UUID id;
    private TipoContato tipo;
    private String valorDoContato;
    
}
