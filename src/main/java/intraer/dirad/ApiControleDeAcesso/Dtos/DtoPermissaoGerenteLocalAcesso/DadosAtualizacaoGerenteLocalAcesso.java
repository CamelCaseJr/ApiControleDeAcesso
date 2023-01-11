package intraer.dirad.ApiControleDeAcesso.Dtos.DtoPermissaoGerenteLocalAcesso;

import java.util.List;

import intraer.dirad.ApiControleDeAcesso.enums.Permissoes;
import intraer.dirad.ApiControleDeAcesso.models.Gerente;
import intraer.dirad.ApiControleDeAcesso.models.PontoDeAcesso;

public record DadosAtualizacaoGerenteLocalAcesso(
    Gerente gerente ,
    List<PontoDeAcesso> localDeAcesso,
    List<Permissoes> permissoes
) {
    
}
