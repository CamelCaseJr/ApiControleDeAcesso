package intraer.dirad.ApiControleDeAcesso.domain.pessoa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID>{

    List<Optional<Pessoa>> findByNome(String nome);

    Optional<Pessoa> findByCpf(String cpf);

}
