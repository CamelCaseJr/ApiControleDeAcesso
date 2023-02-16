package intraer.dirad.ApiControleDeAcesso.Dtos.DtoEmpresa;

import intraer.dirad.ApiControleDeAcesso.models.Contato;
import intraer.dirad.ApiControleDeAcesso.models.Endereco;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DadosCadastroEmpresa {
    private String nome;
    private String cnpj;
    private Contato contato;
    private List<Endereco> endereco = new ArrayList();

}
