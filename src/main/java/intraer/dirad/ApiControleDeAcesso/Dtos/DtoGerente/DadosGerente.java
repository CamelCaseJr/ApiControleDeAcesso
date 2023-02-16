package intraer.dirad.ApiControleDeAcesso.Dtos.DtoGerente;

import intraer.dirad.ApiControleDeAcesso.models.PermissaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
public class DadosGerente {
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;

    private Pessoa Pessoa;

    private List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos = new ArrayList<>();
}
