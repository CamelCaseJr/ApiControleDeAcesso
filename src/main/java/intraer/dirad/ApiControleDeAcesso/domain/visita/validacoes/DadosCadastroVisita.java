package intraer.dirad.ApiControleDeAcesso.domain.visita.validacoes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import intraer.dirad.ApiControleDeAcesso.domain.enums.TipoDeIdentificacao;
import intraer.dirad.ApiControleDeAcesso.domain.evento.Evento;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import intraer.dirad.ApiControleDeAcesso.domain.secao.Secao;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DadosCadastroVisita{
    @NotNull
    private Pessoa visitado;
    @NotNull
    private Pessoa visitante;
    @NotNull
    private Pessoa autorizador;
    @NotNull
    private Pessoa cadastrador;
    @NotNull
    private LocalDateTime entrada;
    private LocalDateTime dataDeCriacao = LocalDateTime.now();
    @NotNull
    private LocalDateTime saida;
    @NotNull
    private LocalDateTime horarioLimiteDeSaida;
    @NotNull
    private TipoDeIdentificacao tipoDeIdentificacao;
    @NotNull
    private List<Evento> eventos = new ArrayList<>();
    @NotNull
    private List<Secao> locaisLiberados = new ArrayList<>();
}