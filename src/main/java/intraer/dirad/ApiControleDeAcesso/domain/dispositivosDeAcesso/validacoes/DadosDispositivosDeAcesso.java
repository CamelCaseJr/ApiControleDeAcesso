package intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.DispositivoDeAcesso;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
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
