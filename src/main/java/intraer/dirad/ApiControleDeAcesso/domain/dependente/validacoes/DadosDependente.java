package intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.dependente.Dependente;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.Responsavel;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosDependente {
    UUID id;
    private Pessoa pessoa;
    private String nome;
    private Responsavel responsavel;

    public DadosDependente(Dependente dependente) {
        this.id = dependente.getId();
        this.pessoa = dependente.getPessoa();
        this.nome = dependente.getPessoa().getNome();
        this.responsavel = dependente.getResponsavel();
    }
}
