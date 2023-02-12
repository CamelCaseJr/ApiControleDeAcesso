package intraer.dirad.ApiControleDeAcesso.models;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import intraer.dirad.ApiControleDeAcesso.enums.TipoDeIdentificacao;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "eventos")
@Data
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//@Column(columnDefinition = "varchar(36)")
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name = "visita_id")
    private Visita visita;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    
    @Enumerated(EnumType.STRING)
    private TipoDeIdentificacao tipoDeIdentificacao;


}
