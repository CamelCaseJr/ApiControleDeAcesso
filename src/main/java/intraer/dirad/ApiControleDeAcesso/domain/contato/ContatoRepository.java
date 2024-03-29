package intraer.dirad.ApiControleDeAcesso.domain.contato;

import intraer.dirad.ApiControleDeAcesso.domain.contato.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, UUID> {
    Optional<Contato> findByValorDoContato(String valorDoContato);

}
