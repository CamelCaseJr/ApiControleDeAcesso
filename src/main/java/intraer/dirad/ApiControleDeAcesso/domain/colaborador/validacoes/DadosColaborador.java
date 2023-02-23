package intraer.dirad.ApiControleDeAcesso.domain.colaborador.validacoes;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.colaborador.Colaborador;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.validacoes.DadosEmpresa;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.validacoes.DadosPessoa;
import lombok.Data;
import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;

@Data
public class DadosColaborador  {
    ModelMapper mapper = new ModelMapper();
    private UUID id;
    private DadosPessoa pessoa;
    private DadosEmpresa empresa;

    public DadosColaborador(Colaborador colaborador) {
        this.id = colaborador.getId();
        this.pessoa =  mapper.map(colaborador.getPessoa(), DadosPessoa.class);
        this.empresa = mapper.map(colaborador.getEmpresa(), DadosEmpresa.class);
    }
}
