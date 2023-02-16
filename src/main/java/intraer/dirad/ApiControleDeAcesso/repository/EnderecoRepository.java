package intraer.dirad.ApiControleDeAcesso.repository;

import intraer.dirad.ApiControleDeAcesso.models.Colaborador;
import intraer.dirad.ApiControleDeAcesso.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
}
