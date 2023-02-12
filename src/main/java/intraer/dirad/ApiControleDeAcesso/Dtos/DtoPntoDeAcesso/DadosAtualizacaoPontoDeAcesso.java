package intraer.dirad.ApiControleDeAcesso.Dtos.DtoPntoDeAcesso;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.models.DispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.models.PermissaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.models.Secao;
import lombok.Data;

@Data
public class DadosAtualizacaoPontoDeAcesso{
    UUID id;
    String nome;
    List<Secao> secao;
    List<DispositivoDeAcesso> dispositivosDeAcesso;
    List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos;
}