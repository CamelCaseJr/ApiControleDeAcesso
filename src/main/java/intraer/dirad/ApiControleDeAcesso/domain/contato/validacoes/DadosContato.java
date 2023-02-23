package intraer.dirad.ApiControleDeAcesso.domain.contato.validacoes;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.contato.Contato;
import intraer.dirad.ApiControleDeAcesso.domain.enums.TipoContato;
import lombok.Data;

@Data
public class DadosContato{
    private UUID id;
    private TipoContato tipo;
    private String valorDoContato;

    public DadosContato(Contato contato) {
        this.id = contato.getId();
        this.tipo = contato.getTipo();
        this.valorDoContato = contato.getValorDoContato();
    }
}
