package intraer.dirad.ApiControleDeAcesso.domain.secao.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.Responsavel;
import intraer.dirad.ApiControleDeAcesso.domain.secao.Secao;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
public class DadosSecao {
    //@Column(columnDefinition = "varchar(36)")

    private UUID id;

    private String nome;
    private String sigla;
    private List<Responsavel> responsaveis = new ArrayList<>();
    private List<Pessoa> pessoas = new ArrayList<>();

    public DadosSecao(Secao secao) {
        this.id = secao.getId();
        this.nome = secao.getNome();
        this.sigla = secao.getSigla();
        this.responsaveis = secao.getResponsaveis();
        this.pessoas = secao.getPessoas();
    }
}
