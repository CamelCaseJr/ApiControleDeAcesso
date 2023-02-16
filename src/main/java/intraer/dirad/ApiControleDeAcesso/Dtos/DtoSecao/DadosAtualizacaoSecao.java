package intraer.dirad.ApiControleDeAcesso.Dtos.DtoSecao;

import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.models.Responsavel;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class DadosAtualizacaoSecao {



    private String nome;
    private String sigla;
    private List<Responsavel> responsaveis = new ArrayList<>();
    private List<Pessoa> pessoas = new ArrayList<>();

}

