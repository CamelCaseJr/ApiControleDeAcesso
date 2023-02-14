package intraer.dirad.ApiControleDeAcesso.facade;

import intraer.dirad.ApiControleDeAcesso.Dtos.DtoPessoa.DadosCadastroPessoa;
import intraer.dirad.ApiControleDeAcesso.models.Contato;
import intraer.dirad.ApiControleDeAcesso.models.Militar;
import intraer.dirad.ApiControleDeAcesso.models.Pessoa;
import intraer.dirad.ApiControleDeAcesso.models.Secao;
import intraer.dirad.ApiControleDeAcesso.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PessoaFacade {

    private final RepositorioGlobal repository;
    private final ModelMapper mapper;

    public Pessoa cria(DadosCadastroPessoa dados)
    {
        var contato = criarContato(dados);
        var militar = criarMilitar(dados);
        var secao = criaSecao(dados);
        return criaPessoa(dados,contato,secao,militar);

    }


    private  Contato criarContato(DadosCadastroPessoa dados) {
        var valorDoContato = dados.getContato().getValorDoContato();
        var tipo = dados.getContato().getTipo();
        if (!valorDoContato.isBlank() && tipo != null){
            return repository.getContatoRepository().save(dados.getContato());
        }else throw new EntityNotFoundException("Contato está em branco");
    }
    private  Militar criarMilitar(DadosCadastroPessoa dados) {
        if (dados.getMilitar() != null) {
            var militar = mapper.map(dados.getMilitar(), Militar.class);
            return repository.getMilitarRepository().save(militar);
        } else return dados.getMilitar();
    }

    protected  List<Secao> criaSecao(DadosCadastroPessoa dados) {
        if (dados.getSetor() != null) {
            return dados.getSetor().stream()
                    .map(repository.getSecaoRepository()::save).collect(Collectors.toList());
        }else throw new EntityNotFoundException("Secao nao pode ser nula");
    }
    private Pessoa criaPessoa(DadosCadastroPessoa dados,
                                     Contato contato,
                                     List<Secao> secao,
                                     Militar militar) {
        var pessoa = mapper.map(dados, Pessoa.class);
        pessoa.setContato(contato);
        pessoa.setSetor(secao);
        pessoa.setMilitar(militar);
        return repository.getPessoaRepository().save(pessoa);
    }



}
