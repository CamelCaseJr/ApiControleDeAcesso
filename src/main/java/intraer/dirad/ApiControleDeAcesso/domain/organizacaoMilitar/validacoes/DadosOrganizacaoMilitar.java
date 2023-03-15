package intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosOrganizacaoMilitar {
    UUID id;
    String nome;
    String sigla;

    public DadosOrganizacaoMilitar(OrganizacaoMilitar organizacaoMilitar) {
        this.id = organizacaoMilitar.getId();
        this.nome = organizacaoMilitar.getNome();
        this.sigla = organizacaoMilitar.getSigla();
    }
}
