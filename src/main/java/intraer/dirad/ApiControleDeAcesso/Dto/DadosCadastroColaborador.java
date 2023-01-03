package intraer.dirad.ApiControleDeAcesso.Dto;

import intraer.dirad.ApiControleDeAcesso.model.Empresa;
import intraer.dirad.ApiControleDeAcesso.model.Pessoa;

public record DadosCadastroColaborador (
    DadosCadastroPessoa pessoa,
    DadosCadastroEmpresa empresa){}
