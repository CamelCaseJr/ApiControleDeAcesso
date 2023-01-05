package intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoEmpresa.DadosEmpresa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosPessoa;

public record DadosColaborador (
    UUID id,
    DadosPessoa pessoa,
    DadosEmpresa empresa
) {

}
