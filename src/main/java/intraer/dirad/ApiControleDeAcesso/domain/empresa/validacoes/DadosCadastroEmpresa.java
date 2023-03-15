package intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.contato.Contato;
import intraer.dirad.ApiControleDeAcesso.domain.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DadosCadastroEmpresa {
    @NotBlank
    private String nome;
    @NotBlank
    @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}")
    private String cnpj;
    @NotNull
    private Contato contato;
    @NotNull
    private List<Endereco> endereco = new ArrayList<>();

}
