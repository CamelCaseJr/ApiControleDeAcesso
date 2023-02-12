package intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoEmpresa.DadosCadastroEmpresa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosCadastroPessoa;
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
