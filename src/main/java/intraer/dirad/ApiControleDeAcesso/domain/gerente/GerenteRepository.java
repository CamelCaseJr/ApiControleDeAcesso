package intraer.dirad.ApiControleDeAcesso.domain.gerente;

import intraer.dirad.ApiControleDeAcesso.domain.gerente.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, UUID> {
}
