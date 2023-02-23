package intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.validacoes;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.DispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.PermissaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.secao.Secao;
import lombok.Data;

@Data
public class DadosCadastroPontoDeAcesso{
    UUID id;
    String nome;
    List<Secao> secao;
    List<DispositivoDeAcesso> dispositivosDeAcesso;
    List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos;
}