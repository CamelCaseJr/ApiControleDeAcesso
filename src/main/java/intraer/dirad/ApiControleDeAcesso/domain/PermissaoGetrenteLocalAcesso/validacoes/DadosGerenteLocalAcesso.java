package intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.validacoes;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.PermissaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.enums.Permissoes;
import intraer.dirad.ApiControleDeAcesso.domain.gerente.Gerente;
import intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.PontoDeAcesso;
import lombok.Data;

@Data
public class DadosGerenteLocalAcesso{
    UUID id;
    Gerente gerente ;
    String nome;
    List<PontoDeAcesso> localDeAcesso;
    List<Permissoes> permissoes;

    public DadosGerenteLocalAcesso(PermissaoGerenteLocalAcesso permissaoGerenteLocalAcesso) {
        this.id = permissaoGerenteLocalAcesso.getId();
        this.gerente = permissaoGerenteLocalAcesso.getGerente();
        this.localDeAcesso = permissaoGerenteLocalAcesso.getLocalDeAcesso();
        this.permissoes = permissaoGerenteLocalAcesso.getPermissoes();
        this.nome = permissaoGerenteLocalAcesso.getGerente().getPessoa().getNome();
    }
}
