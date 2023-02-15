package intraer.dirad.ApiControleDeAcesso.Dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.enums.TipoDeIdentificacao;
import intraer.dirad.ApiControleDeAcesso.models.DispositivoDeAcesso;
import intraer.dirad.ApiControleDeAcesso.models.Evento;
import intraer.dirad.ApiControleDeAcesso.models.PermissaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.models.Secao;
import lombok.Data;

@Data
public class DadosCadastroVisita{
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