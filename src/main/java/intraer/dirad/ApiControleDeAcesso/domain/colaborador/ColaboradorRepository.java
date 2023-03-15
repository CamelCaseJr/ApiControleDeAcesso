package intraer.dirad.ApiControleDeAcesso.domain.colaborador;

import intraer.dirad.ApiControleDeAcesso.domain.colaborador.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, UUID> {
    Optional<Colaborador> findByPessoaCpf(String cpf);

}
