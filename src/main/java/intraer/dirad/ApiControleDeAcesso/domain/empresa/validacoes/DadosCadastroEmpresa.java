package intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.contato.Contato;
import intraer.dirad.ApiControleDeAcesso.domain.endereco.Endereco;
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
