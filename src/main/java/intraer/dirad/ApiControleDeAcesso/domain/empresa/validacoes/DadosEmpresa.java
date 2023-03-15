package intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.contato.Contato;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.Empresa;
import intraer.dirad.ApiControleDeAcesso.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosEmpresa {

    private UUID id;
    private String nome;
    private String cnpj;
    private Contato contato;
    private List<Endereco> endereco = new ArrayList<>();

    public DadosEmpresa(Empresa empresa) {
        this.id = empresa.getId();
        this.nome = empresa.getNome();
        this.cnpj = empresa.getCnpj();
        this.contato = empresa.getContato();
        this.endereco = empresa.getEndereco();
    }


}
