package intraer.dirad.ApiControleDeAcesso.domain.secao.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.Responsavel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DadosCadastroSecao {



    private String nome;
    private String sigla;
    private List<Responsavel> responsaveis = new ArrayList<>();
    private List<Pessoa> pessoas = new ArrayList<>();


}
