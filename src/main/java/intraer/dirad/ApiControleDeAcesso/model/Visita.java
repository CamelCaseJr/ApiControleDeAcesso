package intraer.dirad.ApiControleDeAcesso.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.enums.TipoDeIdentificacao;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(columnDefinition = "varchar(36)")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "visitado_id")
    private Pessoa visitado;
    @OneToOne
    @JoinColumn(name = "visitante_id")
    private Pessoa visitante;
    @OneToOne
    @JoinColumn(name = "autorizador_id")
    private Pessoa autorizador;
    @OneToOne
    @JoinColumn(name = "cadastrador_id")
    private Pessoa cadastrador;
    private LocalDateTime entrada;
    private LocalDateTime dataDeCriacao = LocalDateTime.now();
    private LocalDateTime saida;
    private LocalDateTime horarioLimiteDeSaida;
    @Enumerated
    private TipoDeIdentificacao tipoDeIdentificacao;

    @OneToMany
    private List<Evento> eventos = new ArrayList<>();
    @OneToMany
    private List<secao> locaisLiberados = new ArrayList<>();

}
