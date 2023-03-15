package intraer.dirad.ApiControleDeAcesso.domain.efetivo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EfetivoRepository extends JpaRepository<Efetivo, UUID> {

    Optional<Efetivo> findByOrganizacaoMilitarNome(String nome);

    Optional<Efetivo> findByPessoaNome(String nome);

}
