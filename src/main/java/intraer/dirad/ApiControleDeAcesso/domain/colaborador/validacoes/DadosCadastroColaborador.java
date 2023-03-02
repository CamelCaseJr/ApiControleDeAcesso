package intraer.dirad.ApiControleDeAcesso.domain.colaborador.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes.DadosEmpresa;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.validacoes.DadosPessoa;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;
@Data
public class DadosCadastroColaborador {
    @NotBlank(message = "field cannot be empty")
    private DadosPessoa pessoa;
    @NotBlank(message = "field cannot be empty")
    private DadosEmpresa empresa;
}
