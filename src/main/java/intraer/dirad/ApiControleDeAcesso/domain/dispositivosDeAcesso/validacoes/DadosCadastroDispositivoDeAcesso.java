package intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.validacoes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Blob;
import java.util.UUID;
@Data
public class DadosCadastroDispositivoDeAcesso{

    @NotBlank
    private String nome;
    @NotBlank
    private String tipo;
    @NotNull
    private Blob metadata;
}
