package intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoEmpresa.DadosCadastroEmpresa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosCadastroPessoa;

public record DadosAtualizacaoColaborador (
    UUID id,
    DadosCadastroPessoa pessoa,
    DadosCadastroEmpresa empresa

){}
