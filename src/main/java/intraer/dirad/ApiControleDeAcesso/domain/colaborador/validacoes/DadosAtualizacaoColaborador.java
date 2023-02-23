package intraer.dirad.ApiControleDeAcesso.domain.colaborador.validacoes;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes.DadosCadastroEmpresa;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.validacoes.DadosCadastroPessoa;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DadosAtualizacaoColaborador {
    UUID id;
    @NotBlank(message = "field cannot be empty")
    DadosCadastroPessoa pessoa;
    @NotBlank(message = "field cannot be empty")
    DadosCadastroEmpresa empresa;
}
