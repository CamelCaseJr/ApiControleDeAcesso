package intraer.dirad.ApiControleDeAcesso.Dtos.DtoEndereco;

import lombok.Data;

import java.util.UUID;
@Data
public class DadosCadastroEndereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String numero;
    private String estado;
    private String cidade;
}
