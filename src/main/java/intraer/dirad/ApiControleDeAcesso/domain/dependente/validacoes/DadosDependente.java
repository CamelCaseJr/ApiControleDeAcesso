package intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.dependente.Dependente;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.Responsavel;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.UUID;
@Data
public class DadosDependente {
    UUID id;
    private Pessoa pessoa;
    private String nome;
    private Responsavel responsavel;

    public DadosDependente(Dependente dependente) {
        this.id = dependente.getId();
        this.pessoa = dependente.getPessoas();
        this.nome = dependente.getPessoas().getNome();
        this.responsavel = dependente.getResponsavel();
    }
}
