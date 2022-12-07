package intraer.dirad.ApiControleDeAcesso.model;

import java.util.ArrayList;
import java.util.List;

import intraer.dirad.ApiControleDeAcesso.enums.Permissoes;

public class LocalDeAcesso {
    private String nome;
    private Setor setor;

    
    private List<DispositivoDeAcesso> dispositivosDeAcesso = new ArrayList<>();
    
    private List<PermissaoGerenteLocalAcesso> permissoesGerentesLocaaisAcessos = new ArrayList<>();


}
