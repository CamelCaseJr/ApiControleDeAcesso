package intraer.dirad.ApiControleDeAcesso.domain.colaborador.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes.DadosEmpresa;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.validacoes.DadosPessoa;
import lombok.Data;

import java.util.UUID;
@Data
public class DadosCadastroColaborador {
    private UUID id;
    private DadosPessoa pessoa;
    private DadosEmpresa empresa;
}
