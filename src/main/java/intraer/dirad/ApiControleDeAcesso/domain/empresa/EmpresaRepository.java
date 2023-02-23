package intraer.dirad.ApiControleDeAcesso.domain.empresa;

import intraer.dirad.ApiControleDeAcesso.domain.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, UUID> {
}
