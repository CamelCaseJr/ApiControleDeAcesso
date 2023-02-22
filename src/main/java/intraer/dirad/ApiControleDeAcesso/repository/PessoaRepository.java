package intraer.dirad.ApiControleDeAcesso.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import intraer.dirad.ApiControleDeAcesso.models.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID>{

    Optional<Pessoa> findByNome(String nome);

    Optional<Pessoa> findByCpf(String cpf);

}
