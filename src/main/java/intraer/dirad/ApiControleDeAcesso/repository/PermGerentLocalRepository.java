package intraer.dirad.ApiControleDeAcesso.repository;

import intraer.dirad.ApiControleDeAcesso.models.PermissaoGerenteLocalAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PermGerentLocalRepository extends JpaRepository<PermissaoGerenteLocalAcesso, UUID> {
}
