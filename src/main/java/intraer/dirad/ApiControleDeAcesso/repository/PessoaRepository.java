package intraer.dirad.ApiControleDeAcesso.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import intraer.dirad.ApiControleDeAcesso.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
    
}
