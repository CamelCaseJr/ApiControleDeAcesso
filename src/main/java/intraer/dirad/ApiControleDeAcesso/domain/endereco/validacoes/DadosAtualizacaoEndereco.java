package intraer.dirad.ApiControleDeAcesso.domain.endereco.validacoes;

import lombok.Data;

@Data
public class DadosAtualizacaoEndereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String numero;
    private String estado;
    private String cidade;
}
