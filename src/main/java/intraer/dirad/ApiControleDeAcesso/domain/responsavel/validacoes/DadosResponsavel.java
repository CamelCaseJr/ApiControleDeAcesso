package intraer.dirad.ApiControleDeAcesso.domain.responsavel.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.Responsavel;
import lombok.Data;

import java.util.UUID;
@Data
public class DadosResponsavel {
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;

    private Pessoa Pessoa;
    private String nome;

    public DadosResponsavel(Responsavel responsavel) {
        this.id = responsavel.getId();
        Pessoa = responsavel.getPessoa();
        this.nome = responsavel.getPessoa().getNome();
    }
}
