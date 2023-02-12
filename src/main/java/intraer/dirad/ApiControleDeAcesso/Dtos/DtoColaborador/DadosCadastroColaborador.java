package intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoEmpresa.DadosCadastroEmpresa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoEmpresa.DadosEmpresa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosPessoa;
import intraer.dirad.ApiControleDeAcesso.models.Empresa;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import lombok.Data;

import java.util.UUID;
@Data
public class DadosCadastroColaborador {
    private UUID id;
    private DadosPessoa pessoa;
    private DadosEmpresa empresa;
}
