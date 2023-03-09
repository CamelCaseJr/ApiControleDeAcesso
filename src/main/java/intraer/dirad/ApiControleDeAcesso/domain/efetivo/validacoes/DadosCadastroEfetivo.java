package intraer.dirad.ApiControleDeAcesso.domain.efetivo.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosCadastroEfetivo {

    private OrganizacaoMilitar organizacaoMilitar;
    private List<Pessoa> pessoa;
}
