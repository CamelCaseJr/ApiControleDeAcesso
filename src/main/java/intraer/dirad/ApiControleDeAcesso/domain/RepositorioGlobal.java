package intraer.dirad.ApiControleDeAcesso.domain;

import intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.PontoDeAcessoRepository;
import intraer.dirad.ApiControleDeAcesso.domain.colaborador.ColaboradorRepository;
import intraer.dirad.ApiControleDeAcesso.domain.contato.ContatoRepository;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.DependenteRepository;
import intraer.dirad.ApiControleDeAcesso.domain.empresa.EmpresaRepository;
import intraer.dirad.ApiControleDeAcesso.domain.militar.MilitarRepository;
import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OMRepository;
import intraer.dirad.ApiControleDeAcesso.domain.pessoa.PessoaRepository;
import intraer.dirad.ApiControleDeAcesso.domain.secao.SecaoRepository;
import intraer.dirad.ApiControleDeAcesso.domain.visita.VisitaRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
@AllArgsConstructor
public class RepositorioGlobal {
    private final ColaboradorRepository colaboradorRepository;
    private final ContatoRepository contatoRepository;
    private final DependenteRepository dependenteRepository;
    private final MilitarRepository militarRepository;
    private final OMRepository omRepository;
    private final PontoDeAcessoRepository pontoDeAcessoRepository;
    private final SecaoRepository secaoRepository;
    private final PessoaRepository pessoaRepository;
    private final VisitaRepository visitaRepository;
    private final EmpresaRepository empresaRepository;

}
