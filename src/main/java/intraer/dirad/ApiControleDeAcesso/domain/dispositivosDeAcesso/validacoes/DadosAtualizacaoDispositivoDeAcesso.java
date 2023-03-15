package intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.validacoes;

import lombok.Data;

import java.sql.Blob;
import java.util.UUID;
@Data
public class DadosAtualizacaoDispositivoDeAcesso{

    private String nome;
    private String tipo;
    private Blob metadata;
}
