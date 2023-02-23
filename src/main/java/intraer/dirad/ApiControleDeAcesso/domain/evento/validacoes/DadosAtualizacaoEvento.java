package intraer.dirad.ApiControleDeAcesso.domain.evento.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.enums.TipoDeIdentificacao;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.visita.Visita;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DadosAtualizacaoEvento {

    private Pessoa pessoa;
    private Visita visita;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private TipoDeIdentificacao tipoDeIdentificacao;
}
