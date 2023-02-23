package intraer.dirad.ApiControleDeAcesso.domain.visita.validacoes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import intraer.dirad.ApiControleDeAcesso.domain.enums.TipoDeIdentificacao;
import intraer.dirad.ApiControleDeAcesso.domain.evento.Evento;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.secao.Secao;
import lombok.Data;

@Data
public class DadosAtualizacaoVisita{
    private Pessoa visitado;
    private Pessoa visitante;
    private Pessoa autorizador;
    private Pessoa cadastrador;
    private LocalDateTime entrada;
    private LocalDateTime dataDeCriacao = LocalDateTime.now();
    private LocalDateTime saida;
    private LocalDateTime horarioLimiteDeSaida;
    private TipoDeIdentificacao tipoDeIdentificacao;
    private List<Evento> eventos = new ArrayList<>();
    private List<Secao> locaisLiberados = new ArrayList<>();
}