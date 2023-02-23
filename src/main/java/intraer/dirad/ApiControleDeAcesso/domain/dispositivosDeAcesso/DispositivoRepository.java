package intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import intraer.dirad.ApiControleDeAcesso.domain.dispositivosDeAcesso.DispositivoDeAcesso;

@Repository
public interface DispositivoRepository extends JpaRepository<DispositivoDeAcesso, UUID>{
    
}
