package intraer.dirad.ApiControleDeAcesso.model;

import java.time.LocalDateTime;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.enums.TipoDeIdentificacao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "eventos")
@Data
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "varchar(36)")
    private UUID id;
    
    private Pessoa pessoa;
    private Visita visita;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    
    @Enumerated(EnumType.STRING)
    private TipoDeIdentificacao tipoDeIdentificacao;


}
