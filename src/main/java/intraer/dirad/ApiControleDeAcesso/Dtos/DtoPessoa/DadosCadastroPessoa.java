package intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.models.Contato;
import intraer.dirad.ApiControleDeAcesso.models.Dependente;
import intraer.dirad.ApiControleDeAcesso.models.Militar;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.models.Secao;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DadosCadastroPessoa {
    private UUID id;
    private String nome;
    private String cpf;
    private Contato contato;
    private String sexo;
    private List<Secao> setor;
    private Militar militar;
    private List<Dependente> dependentes;
}
