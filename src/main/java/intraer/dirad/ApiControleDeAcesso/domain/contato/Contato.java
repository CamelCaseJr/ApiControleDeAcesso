package intraer.dirad.ApiControleDeAcesso.domain.contato;

import intraer.dirad.ApiControleDeAcesso.domain.enums.TipoContato;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor

public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//@Column(columnDefinition = "varchar(36)")
    private UUID id;
    
    @Enumerated(EnumType.STRING)
    private TipoContato tipo;
    
    private String valorDoContato;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Contato contato = (Contato) o;
        return id != null && Objects.equals(id, contato.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
