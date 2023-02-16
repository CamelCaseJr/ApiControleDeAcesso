package intraer.dirad.ApiControleDeAcesso.repository;

import intraer.dirad.ApiControleDeAcesso.models.Endereco;
import intraer.dirad.ApiControleDeAcesso.models.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, UUID> {
}
