package intraer.dirad.ApiControleDeAcesso.domain.gerente.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.PermissaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DadosCadastroGerente {

    private Pessoa Pessoa;

    private List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos = new ArrayList<>();
}
