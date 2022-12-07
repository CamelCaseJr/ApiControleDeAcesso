package intraer.dirad.ApiControleDeAcesso.model;

import java.util.ArrayList;
import java.util.List;

import intraer.dirad.ApiControleDeAcesso.enums.Permissoes;

public class PermissaoGerenteLocalAcesso {
    private Gerente gerente;
    private LocalDeAcesso localDeAcesso;
    

    private List<Permissoes> permissoes = new ArrayList();
}
