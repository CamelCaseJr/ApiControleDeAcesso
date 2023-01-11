package intraer.dirad.ApiControleDeAcesso.Dtos.DtoPermissaoGerenteLocalAcesso;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.enums.Permissoes;
import intraer.dirad.ApiControleDeAcesso.models.Gerente;
import intraer.dirad.ApiControleDeAcesso.models.PontoDeAcesso;

public record DadosCadastroGerenteLocalAcesso(
    Gerente gerente ,
    List<PontoDeAcesso> localDeAcesso,
    List<Permissoes> permissoes
) {
    
}
