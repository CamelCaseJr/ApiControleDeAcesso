package intraer.dirad.ApiControleDeAcesso.domain.militar.validacoes;

import java.util.UUID;

import intraer.dirad.ApiControleDeAcesso.domain.militar.Militar;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitar;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosMilitar{
    private UUID id;
    private String saram;
    private Pessoa pessoa;
    private String nomeDeGuerra;
    private OrganizacaoMilitar om;
    private String posto;

    public DadosMilitar(Militar militar) {
        this.id = militar.getId();
        this.saram = militar.getSaram();
        this.pessoa = militar.getPessoa();
        this.nomeDeGuerra = militar.getNomeDeGuerra();
        this.om = militar.getOm();
        this.posto = militar.getPosto();
    }
}
