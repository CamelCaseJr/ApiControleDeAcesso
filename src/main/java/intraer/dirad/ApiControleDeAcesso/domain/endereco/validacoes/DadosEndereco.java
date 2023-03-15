package intraer.dirad.ApiControleDeAcesso.domain.endereco.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosEndereco {
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;

    private String cep;
    private String logradouro;
    private String complemento;
    private String numero;
    private String estado;
    private String cidade;

    public DadosEndereco(Endereco endereco) {
        this.id = endereco.getId();
        this.cep = endereco.getCep();
        this.logradouro = endereco.getLogradouro();
        this.complemento = endereco.getComplemento();
        this.numero = endereco.getNumero();
        this.estado = endereco.getEstado();
        this.cidade = endereco.getCidade();
    }
}
