package intraer.dirad.ApiControleDeAcesso.domain.responsavel;

import intraer.dirad.ApiControleDeAcesso.domain.responsavel.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, UUID> {
}
