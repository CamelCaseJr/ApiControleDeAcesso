package intraer.dirad.ApiControleDeAcesso.Dto;

import java.util.List;

import intraer.dirad.ApiControleDeAcesso.model.Pessoa;

public class PessoaDto {

    private String nome;
    private String cpf;
    private Contato contato;
    private String sexo;
    private secao setor;
    private Militar militar;
    
    private List<Dependente> dependentes;

    public PessoaDto(Pessoa pessoa){
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.contato = pessoa.getContato();
        this.sexo = pessoa.getSexo();
        this.setor = pessoa.getSetor();
        this.militar = pessoa.getMilitar();
        this.dependentes = pessoa.getDependentes();
    }

    public static List<PessoaDto> ConverterPessoa(List<Pessoa> pessoas) {
        return pessoas.stream().map(PessoaDto::new).toList();
    }
    
}
