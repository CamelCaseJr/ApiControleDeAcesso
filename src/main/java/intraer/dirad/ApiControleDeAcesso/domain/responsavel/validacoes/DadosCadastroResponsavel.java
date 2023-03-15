package intraer.dirad.ApiControleDeAcesso.domain.responsavel.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DadosCadastroResponsavel {

    @NotNull
    private Pessoa Pessoa;


}
