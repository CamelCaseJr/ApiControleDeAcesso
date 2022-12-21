package intraer.dirad.ApiControleDeAcesso.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import intraer.dirad.ApiControleDeAcesso.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID>{
    
}
