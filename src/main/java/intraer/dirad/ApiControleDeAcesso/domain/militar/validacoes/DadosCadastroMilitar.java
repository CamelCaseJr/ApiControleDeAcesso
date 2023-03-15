package intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NonNull;

@Data
public class DadosCadastroMilitar {
    @NotBlank
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\-\\d{1}")
    private String saram;
    @NonNull
    private Pessoa pessoa;
    @NotBlank
    private String nomeDeGuerra;
    @NonNull
    private OrganizacaoMilitar om;
    @NotBlank
    private String posto;
    
}
