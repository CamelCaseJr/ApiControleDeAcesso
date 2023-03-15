package intraer.dirad.ApiControleDeAcesso.domain.efetivo.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosCadastroEfetivo {

    @NotNull
    private OrganizacaoMilitar organizacaoMilitar;
    @NotNull
    private List<Pessoa> pessoa;
}
