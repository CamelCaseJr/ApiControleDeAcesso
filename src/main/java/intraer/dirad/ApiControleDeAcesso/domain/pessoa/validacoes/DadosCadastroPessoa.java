package intraer.dirad.ApiControleDeAcesso.domain.pessoa.validacoes;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.contato.Contato;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.Dependente;
import intraer.dirad.ApiControleDeAcesso.domain.militar.Militar;
import intraer.dirad.ApiControleDeAcesso.domain.secao.Secao;
import lombok.Data;

@Data
public class DadosCadastroPessoa {
    private UUID id;
    private String nome;
    private String cpf;
    private String sexo;

}
