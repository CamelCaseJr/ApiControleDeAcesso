package intraer.dirad.ApiControleDeAcesso.domain.evento.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.enums.TipoDeIdentificacao;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.visita.Visita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DadosCadastroEvento {

    @NotNull
    private Pessoa pessoa;
    @NotNull
    private Visita visita;
    @NotNull
    private TipoDeIdentificacao tipoDeIdentificacao;
}
