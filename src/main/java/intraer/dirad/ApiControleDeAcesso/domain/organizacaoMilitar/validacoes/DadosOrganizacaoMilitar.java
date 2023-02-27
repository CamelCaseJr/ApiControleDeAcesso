package intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitar;
import lombok.Data;

import java.util.UUID;
@Data
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
