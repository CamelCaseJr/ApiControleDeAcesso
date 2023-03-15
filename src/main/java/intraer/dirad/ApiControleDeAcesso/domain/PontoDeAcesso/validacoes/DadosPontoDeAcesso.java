package intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.validacoes;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.PontoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.DispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.secao.Secao;
import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.PermissaoGerenteLocalAcesso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosPontoDeAcesso {
    UUID id;
    String nome;
    List<Secao> secao;
    List<DispositivoDeAcesso> dispositivosDeAcesso;
    List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos;

    public DadosPontoDeAcesso(PontoDeAcesso pontoDeAcesso) {
        this.id = pontoDeAcesso.getId();
        this.nome = pontoDeAcesso.getNome();
        this.secao = pontoDeAcesso.getSecao();
        this.dispositivosDeAcesso = pontoDeAcesso.getDispositivosDeAcesso();
        this.permissoesGerentesLocaaisAcessos = pontoDeAcesso.getPermissoesGerentesLocaaisAcessos();
    }
}
