package intraer.dirad.ApiControleDeAcesso.domain.visita;

import intraer.dirad.ApiControleDeAcesso.domain.visita.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, UUID> {

}
