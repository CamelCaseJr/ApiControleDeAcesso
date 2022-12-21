package intraer.dirad.ApiControleDeAcesso.model;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.enums.TipoContato;
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
@Table(name = "contatos")
@Data
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//@Column(columnDefinition = "varchar(36)")
    private UUID id;
    
    @Enumerated(EnumType.STRING)
    private TipoContato tipo;
    
    private String valorDoContato;

}
