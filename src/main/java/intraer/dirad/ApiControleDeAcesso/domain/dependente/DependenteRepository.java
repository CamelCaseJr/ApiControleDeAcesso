package intraer.dirad.ApiControleDeAcesso.domain.dependente;

import intraer.dirad.ApiControleDeAcesso.domain.dependente.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, UUID> {
}
