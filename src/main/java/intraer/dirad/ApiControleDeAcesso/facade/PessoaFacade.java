package intraer.dirad.ApiControleDeAcesso.facade;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.models.Contato;
import intraer.dirad.ApiControleDeAcesso.models.Militar;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.models.Secao;
import intraer.dirad.ApiControleDeAcesso.repository.ContatoRepository;
import intraer.dirad.ApiControleDeAcesso.repository.MilitarRepository;
import intraer.dirad.ApiControleDeAcesso.repository.PessoaRepository;
import intraer.dirad.ApiControleDeAcesso.repository.SecaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


public class PessoaFacade {

    public static Pessoa cria(PessoaRepository pessoaRepository,
                              ContatoRepository contatoRepository,
                              ModelMapper mapper,
                              SecaoRepository secaoRepository,
                              MilitarRepository militarRepository,
                              DadosCadastroPessoa dados)
    {
        var contato = criarContato(contatoRepository, dados);
        var militar = criarMilitar(mapper, militarRepository, dados);
        var secao = criaSecao(secaoRepository, dados);
        return criaPessoa(pessoaRepository,mapper,dados,contato,secao,militar);


    }
    private static Contato criarContato(ContatoRepository contatoRepository,
                                        DadosCadastroPessoa dados) {
        var valorDoContato = dados.getContato().getValorDoContato();
        var tipo = dados.getContato().getTipo();
        if (!valorDoContato.isBlank() && tipo != null){
            return contatoRepository.save(dados.getContato());
        }else throw new EntityNotFoundException("Contato está em branco");
    }
    private static Militar criarMilitar(ModelMapper mapper,
                                        MilitarRepository militarRepository,
                                        DadosCadastroPessoa dados) {
        var militar = mapper.map(dados.getMilitar(), Militar.class);
        if (militar != null) {
            return militarRepository.save(militar);
        } else return militar;
    }

    protected static List<Secao> criaSecao(SecaoRepository secaoRepository,
                                           DadosCadastroPessoa dados) {
        return dados.getSetor().stream()
                .map(secaoRepository::save).collect(Collectors.toList());
    }
    private static Pessoa criaPessoa(PessoaRepository pessoaRepository,
                                     ModelMapper mapper,
                                     DadosCadastroPessoa dados,
                                     Contato contato,
                                     List<Secao> secao,
                                     Militar militar) {
        var pessoa = mapper.map(dados, Pessoa.class);
        pessoa.setContato(contato);
        pessoa.setSetor(secao);
        pessoa.setMilitar(militar);
        return pessoaRepository.save(pessoa);
    }
}
