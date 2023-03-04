package intraer.dirad.ApiControleDeAcesso.domain.colaborador.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.pessoa.validacoes.DadosCadastroPessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
public class DadosCadastroColaborador {
    @NotBlank
    UUID idpessoa;
    @NotBlank
    UUID idEmpresa;

}
