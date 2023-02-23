package intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.validacoes;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.enums.Permissoes;
import intraer.dirad.ApiControleDeAcesso.domain.gerente.Gerente;
import intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.PontoDeAcesso;
import lombok.Data;

@Data
public class DadosAtualizacaoGerenteLocalAcesso {
    UUID id;
    Gerente gerente ;
    List<PontoDeAcesso> localDeAcesso;
    List<Permissoes> permissoes;
    
}
