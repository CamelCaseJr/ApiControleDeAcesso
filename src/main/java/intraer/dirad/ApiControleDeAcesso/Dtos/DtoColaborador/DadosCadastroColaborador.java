package intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoEmpresa.DadosCadastroEmpresa;
import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.model.Empresa;
import intraer.dirad.ApiControleDeAcesso.model.Pessoa;

public record DadosCadastroColaborador (
    DadosCadastroPessoa pessoa,
    DadosCadastroEmpresa empresa){}
