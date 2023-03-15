package intraer.dirad.ApiControleDeAcesso.domain.endereco.validacoes;

import lombok.Data;

@Data
public class DadosCadastroEndereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String numero;
    private String estado;
    private String cidade;
}
