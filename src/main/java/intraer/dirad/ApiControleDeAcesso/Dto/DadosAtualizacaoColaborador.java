package intraer.dirad.ApiControleDeAcesso.Dto;

import java.util.UUID;

public record DadosAtualizacaoColaborador (
    UUID id,
    DadosCadastroPessoa pessoa,
    DadosCadastroEmpresa empresa

){}
