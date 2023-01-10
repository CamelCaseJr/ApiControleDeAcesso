package intraer.dirad.ApiControleDeAcesso.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Efetivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//@Column(columnDefinition = "varchar(36)")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}