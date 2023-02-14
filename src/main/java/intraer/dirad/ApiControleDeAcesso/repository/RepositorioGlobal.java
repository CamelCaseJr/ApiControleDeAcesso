package intraer.dirad.ApiControleDeAcesso.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
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
}
