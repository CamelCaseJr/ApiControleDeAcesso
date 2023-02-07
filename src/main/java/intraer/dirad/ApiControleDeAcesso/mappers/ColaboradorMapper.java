package intraer.dirad.ApiControleDeAcesso.mappers;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoColaborador.DadosColaborador;
import intraer.dirad.ApiControleDeAcesso.models.Colaborador;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ColaboradorMapper {
    DadosColaborador entityToDto(Colaborador colaborador);
}
