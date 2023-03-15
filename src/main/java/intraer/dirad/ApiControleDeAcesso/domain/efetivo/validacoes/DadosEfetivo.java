package intraer.dirad.ApiControleDeAcesso.domain.efetivo.validacoes;

import intraer.dirad.ApiControleDeAcesso.domain.efetivo.Efetivo;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosEfetivo {

    private UUID id;
    private List<Pessoa> pessoa;
    private OrganizacaoMilitar organizacaoMilitar;

    public DadosEfetivo(Efetivo efetivo) {
        this.organizacaoMilitar = efetivo.getOrganizacaoMilitar();
        this.id = efetivo.getId();
        this.pessoa = efetivo.getPessoa();
    }
}
