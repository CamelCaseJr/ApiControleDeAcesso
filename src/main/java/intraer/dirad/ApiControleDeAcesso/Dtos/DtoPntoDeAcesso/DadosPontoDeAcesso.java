package intraer.dirad.ApiControleDeAcesso.Dtos.DtoPntoDeAcesso;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.models.DispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.models.Secao;
import intraer.dirad.ApiControleDeAcesso.models.PermissaoGerenteLocalAcesso;
import lombok.Data;

@Data
public class DadosPontoDeAcesso {
    UUID id;
    String nome;
    List<Secao> secao;
    List<DispositivoDeAcesso> dispositivosDeAcesso;
    List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos;
    
}
