package intraer.dirad.ApiControleDeAcesso.Dtos.DtoPntoDeAcesso;

import java.util.List;

import intraer.dirad.ApiControleDeAcesso.models.DispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.models.PermissaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.models.Secao;

public record DadosAtualizacaoPontoDeAcesso(
    String nome,
    List<Secao> secao,
    List<DispositivoDeAcesso> dispositivosDeAcesso,
    List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos
) {
    
}
