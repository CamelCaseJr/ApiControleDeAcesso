package intraer.dirad.ApiControleDeAcesso.domain.visita.validacoes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.enums.TipoDeIdentificacao;
import intraer.dirad.ApiControleDeAcesso.domain.evento.Evento;
import intraer.dirad.ApiControleDeAcesso.domain.secao.Secao;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.visita.Visita;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosVisita {
    private UUID id;

  
    private Pessoa visitado;
    private Pessoa visitante;
    private Pessoa autorizador;
    private Pessoa cadastrador;
    private LocalDateTime entrada;
    private LocalDateTime dataDeCriacao;
    private LocalDateTime saida;
    private LocalDateTime horarioLimiteDeSaida;
    private TipoDeIdentificacao tipoDeIdentificacao;
    private List<Evento> eventos ;
    private List<Secao> locaisLiberados ;
    private String nome;

    public DadosVisita(Visita visita) {
        this.id = visita.getId();
        this.visitado = visita.getVisitado();
        this.visitante = visita.getVisitante();
        this.autorizador = visita.getAutorizador();
        this.cadastrador = visita.getCadastrador();
        this.entrada = visita.getEntrada();
        this.saida = visita.getSaida();
        this.dataDeCriacao = visita.getDataDeCriacao();
        this.horarioLimiteDeSaida = visita.getHorarioLimiteDeSaida();
        this.tipoDeIdentificacao = visita.getTipoDeIdentificacao();
        this.eventos = visita.getEventos();
        this.locaisLiberados = visita.getLocaisLiberados();
        this.nome = visita.getVisitante().getNome();
    }
}
