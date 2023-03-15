package intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso;

import intraer.dirad.ApiControleDeAcesso.domain.PermissaoGetrenteLocalAcesso.PermissaoGerenteLocalAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PermGerentLocalRepository extends JpaRepository<PermissaoGerenteLocalAcesso, UUID> {
}
