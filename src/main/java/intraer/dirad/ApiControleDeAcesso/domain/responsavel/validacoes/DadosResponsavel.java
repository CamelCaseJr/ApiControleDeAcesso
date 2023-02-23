package intraer.dirad.ApiControleDeAcesso.domain.responsavel.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import lombok.Data;

import java.util.UUID;
@Data
public class DadosResponsavel {
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;

    private Pessoa Pessoa;

}
