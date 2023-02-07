package intraer.dirad.ApiControleDeAcesso.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import intraer.dirad.ApiControleDeAcesso.models.DispositivoDeAcesso;

@Repository
public interface DispositivoRepository extends JpaRepository<DispositivoDeAcesso, UUID>{
    
}
