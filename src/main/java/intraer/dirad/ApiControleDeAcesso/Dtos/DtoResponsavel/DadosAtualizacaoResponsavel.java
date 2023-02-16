package intraer.dirad.ApiControleDeAcesso.Dtos.DtoResponsavel;

import intraer.dirad.ApiControleDeAcesso.models.PermissaoGerenteLocalAcesso;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class DadosAtualizacaoResponsavel {


    private Pessoa pessoa;

}

