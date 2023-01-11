package intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa;

import java.util.List;

import intraer.dirad.ApiControleDeAcesso.models.Contato;
import intraer.dirad.ApiControleDeAcesso.models.Dependente;
import intraer.dirad.ApiControleDeAcesso.models.Militar;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.models.Secao;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public record DadosCadastroPessoa (
    @NotNull @NotEmpty
    String nome,
    @NotNull @NotEmpty
    String cpf,
    @NotNull @NotEmpty
    Contato contato,
    @NotNull @NotEmpty
    String sexo,
    @NotNull @NotEmpty
    List<Secao> setor,
    @NotNull @NotEmpty
    Militar militar,
    List<Dependente> dependentes

){}
