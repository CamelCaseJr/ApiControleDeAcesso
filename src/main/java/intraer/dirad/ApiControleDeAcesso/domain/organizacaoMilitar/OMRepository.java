package intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar;

import intraer.dirad.ApiControleDeAcesso.domain.organizacaoMilitar.OrganizacaoMilitar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface OMRepository extends JpaRepository<OrganizacaoMilitar, UUID> {
}
