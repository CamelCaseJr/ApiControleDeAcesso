package intraer.dirad.ApiControleDeAcesso.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
public class secao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "varchar(36)")
    private UUID id;
    
    private String nome;
    private String sigla;
    private Pessoa responsavel;

    private List<Pessoa> efetivo = new ArrayList<>();

}
