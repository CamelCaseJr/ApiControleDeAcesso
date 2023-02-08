package intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa;

import java.util.List;
import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoContato.DadosContato;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.BeanUtils;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import intraer.dirad.ApiControleDeAcesso.models.Contato;
import intraer.dirad.ApiControleDeAcesso.models.Dependente;
import intraer.dirad.ApiControleDeAcesso.models.Militar;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.models.Secao;

@Data
public class DadosPessoa{

    private UUID id;
    private String nome;
    private String cpf;
    private Contato contato;
    private String sexo;
    private List<Secao> setor;
    private Militar militar;
    private List<Dependente> dependentes;
}
