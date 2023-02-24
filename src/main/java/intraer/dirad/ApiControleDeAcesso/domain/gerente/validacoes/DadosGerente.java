package intraer.dirad.ApiControleDeAcesso.domain.gerente.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.PermissaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.gerente.Gerente;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
public class DadosGerente {
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;

    private Pessoa Pessoa;
    private String nome;

    private List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos = new ArrayList<>();

    public DadosGerente(Gerente gerente) {
        this.id = gerente.getId();
        Pessoa = gerente.getPessoa();
        this.nome = gerente.getPessoa().getNome();
        this.permissoesGerentesLocaaisAcessos = gerente.getPermissoesGerentesLocaaisAcessos();
    }
}
