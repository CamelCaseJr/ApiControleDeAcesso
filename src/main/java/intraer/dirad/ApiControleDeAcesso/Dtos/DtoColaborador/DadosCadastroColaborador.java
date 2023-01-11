package intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoEmpresa.DadosCadastroEmpresa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.models.Empresa;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;

public record DadosCadastroColaborador (
    DadosCadastroPessoa pessoa,
    DadosCadastroEmpresa empresa){}
