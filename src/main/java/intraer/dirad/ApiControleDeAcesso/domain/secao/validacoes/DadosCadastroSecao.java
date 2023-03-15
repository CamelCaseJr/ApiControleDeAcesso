package intraer.dirad.ApiControleDeAcesso.domain.secao.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.Responsavel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DadosCadastroSecao {
    @NotBlank
    private String nome;
    @NotBlank
    private String sigla;
    @NotNull
    private List<Responsavel> responsaveis = new ArrayList<>();
    @NotNull
    private List<Pessoa> pessoas = new ArrayList<>();


}
