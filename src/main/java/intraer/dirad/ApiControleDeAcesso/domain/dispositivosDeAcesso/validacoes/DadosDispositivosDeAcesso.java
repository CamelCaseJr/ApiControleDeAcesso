package intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.DispositivoDeAcesso;
import jakarta.persistence.Lob;
import lombok.Data;

import java.sql.Blob;
import java.util.UUID;
@Data
public class DadosDispositivosDeAcesso {
    UUID id;
    private String nome;
    private String tipo;
    private Blob metadata;
    public DadosDispositivosDeAcesso(DispositivoDeAcesso dispositivoDeAcesso) {
        this.id =dispositivoDeAcesso.getId();
        this.nome = dispositivoDeAcesso.getNome();
        this.tipo = dispositivoDeAcesso.getTipo();
        this.metadata = dispositivoDeAcesso.getMetadata();
    }

}
