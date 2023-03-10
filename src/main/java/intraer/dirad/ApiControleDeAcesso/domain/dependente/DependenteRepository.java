package intraer.dirad.ApiControleDeAcesso.domain.dependente;

import intraer.dirad.ApiControleDeAcesso.domain.dependente.Dependente;
import intraer.dirad.ApiControleDeAcesso.domain.dependente.validacoes.DadosDependente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, UUID> {
    Optional<Dependente> findByPessoaNome(String nome);

}
