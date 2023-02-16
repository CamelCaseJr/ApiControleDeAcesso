package intraer.dirad.ApiControleDeAcesso.Dtos.DtoEvento;

import intraer.dirad.ApiControleDeAcesso.enums.TipoDeIdentificacao;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.models.Visita;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DadosAtualizacaoEvento {

    private Pessoa pessoa;
    private Visita visita;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private TipoDeIdentificacao tipoDeIdentificacao;
}
