package intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.Responsavel;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;
@Data
public class DadosDeAtualizacaoDependente {
    @NotNull
    private Pessoa pessoas;
    @NotNull
    private Responsavel responsavel ;
}
