package intraer.dirad.ApiControleDeAcesso.Dtos.DtoGerente;

import intraer.dirad.ApiControleDeAcesso.models.PermissaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DadosAtualizacaoGerente {


    private Pessoa Pessoa;

    private List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos = new ArrayList<>();
}
