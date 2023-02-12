package intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoEmpresa.DadosEmpresa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosPessoa;
import lombok.Data;

@Data
public class DadosColaborador  {
    private UUID id;
    private DadosPessoa pessoa;
    private DadosEmpresa empresa;

}
