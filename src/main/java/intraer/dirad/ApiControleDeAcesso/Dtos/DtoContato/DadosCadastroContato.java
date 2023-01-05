package intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.enums.TipoContato;

public record DadosCadastroContato(
    TipoContato tipo,
    String valorDoContato
) {
    
}
