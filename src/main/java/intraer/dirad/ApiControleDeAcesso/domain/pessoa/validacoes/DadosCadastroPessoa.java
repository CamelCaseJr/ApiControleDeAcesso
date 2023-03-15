package intraer.dirad.ApiControleDeAcesso.domain.pessoa.validacoes;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.contato.Contato;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.Dependente;
import intraer.dirad.ApiControleDeAcesso.domain.militar.Militar;
import intraer.dirad.ApiControleDeAcesso.domain.secao.Secao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DadosCadastroPessoa {
    @NotBlank
    private String nome;
    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
    private String cpf;
    @NotBlank
    private String sexo;
}
