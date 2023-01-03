package intraer.dirad.ApiControleDeAcesso.Dto;

import java.util.List;

import intraer.dirad.ApiControleDeAcesso.model.Contato;
import intraer.dirad.ApiControleDeAcesso.model.Dependente;
import intraer.dirad.ApiControleDeAcesso.model.Militar;
import intraer.dirad.ApiControleDeAcesso.model.Pessoa;
import intraer.dirad.ApiControleDeAcesso.model.secao;
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
    List<secao> setor,
    @NotNull @NotEmpty
    Militar militar,
    List<Dependente> dependentes

){}
