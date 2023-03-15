package intraer.dirad.ApiControleDeAcesso.domain.secao;

import intraer.dirad.ApiControleDeAcesso.domain.secao.Secao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SecaoRepository extends JpaRepository<Secao, UUID> {
}
