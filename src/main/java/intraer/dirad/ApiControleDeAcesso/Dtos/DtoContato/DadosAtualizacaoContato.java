package intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato;

import intraer.dirad.ApiControleDeAcesso.enums.TipoContato;
import lombok.Data;

import java.util.UUID;
@Data
public class DadosAtualizacaoContato {
    private UUID id;
    private TipoContato tipo;
    private String valorDoContato;
    
}
