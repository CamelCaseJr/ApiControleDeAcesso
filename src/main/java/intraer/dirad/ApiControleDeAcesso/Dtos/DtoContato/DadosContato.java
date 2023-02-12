package intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.enums.TipoContato;
import lombok.Data;

@Data
public class DadosContato{
    private UUID id;
    private TipoContato tipo;
    private String valorDoContato;
    
    
}
