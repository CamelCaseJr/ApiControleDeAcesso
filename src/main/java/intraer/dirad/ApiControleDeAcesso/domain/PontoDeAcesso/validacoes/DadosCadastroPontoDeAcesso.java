package intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.validacoes;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.DispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.PermissaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.domain.secao.Secao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class DadosCadastroPontoDeAcesso{

    @NotBlank
    String nome;
    @NotNull
    List<Secao> secao;
    @NotNull
    List<DispositivoDeAcesso> dispositivosDeAcesso;
    @NotNull
    List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos;
}