package intraer.dirad.ApiControleDeAcesso.Dto;

import java.util.UUID;

public record DadosColaborador (
    UUID id,
    DadosPessoa pessoa,
    DadosEmpresa empresa
) {

}
