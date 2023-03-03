package intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.responsavel.Responsavel;
import lombok.Data;

import java.util.UUID;

@Data
public class DadosCadastroDependente
{    UUID id;
    private Pessoa pessoas;
    private Responsavel responsavel ;
    
}
