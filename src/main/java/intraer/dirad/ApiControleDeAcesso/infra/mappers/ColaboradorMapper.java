package intraer.dirad.ApiControleDeAcesso.infra.mappers;

import intraer.dirad.ApiControleDeAcesso.domain.colaborador.validacoes.DadosColaborador;
import intraer.dirad.ApiControleDeAcesso.domain.colaborador.Colaborador;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ColaboradorMapper {
    DadosColaborador entityToDto(Colaborador colaborador);
}
