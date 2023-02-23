package intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso;

import intraer.dirad.ApiControleDeAcesso.domain.PontoDeAcesso.PontoDeAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PontoDeAcessoRepository extends JpaRepository<PontoDeAcesso, UUID> {
}
