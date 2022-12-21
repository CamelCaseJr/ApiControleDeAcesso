package intraer.dirad.ApiControleDeAcesso.form;

import java.util.List;

import intraer.dirad.ApiControleDeAcesso.model.Contato;
import intraer.dirad.ApiControleDeAcesso.model.Dependente;
import intraer.dirad.ApiControleDeAcesso.model.Militar;
import intraer.dirad.ApiControleDeAcesso.model.Pessoa;
import intraer.dirad.ApiControleDeAcesso.model.secao;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PessoaForm {
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String cpf;
    @NotNull @NotEmpty
    private Contato contato;
    @NotNull @NotEmpty
    private String sexo;
    @NotNull @NotEmpty
    private List<secao> setor;
    @NotNull @NotEmpty
    private Militar militar;
    private List<Dependente> dependentes;

}
