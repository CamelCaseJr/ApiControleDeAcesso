package intraer.dirad.ApiControleDeAcesso.Dtos.DtoEndereco;

import lombok.Data;

import java.util.UUID;
@Data
public class DadosEndereco {
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;

    private String cep;
    private String logradouro;
    private String complemento;
    private String numero;
    private String estado;
    private String cidade;
}
