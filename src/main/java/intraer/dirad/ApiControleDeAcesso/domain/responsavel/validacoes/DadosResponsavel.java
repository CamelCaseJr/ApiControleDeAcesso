package intraer.dirad.ApiControleDeAcesso.domain.responsavel.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.Responsavel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
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
