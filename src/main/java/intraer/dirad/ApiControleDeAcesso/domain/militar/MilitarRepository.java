package intraer.dirad.ApiControleDeAcesso.domain.militar;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import intraer.dirad.ApiControleDeAcesso.domain.militar.Militar;

@Repository
public interface MilitarRepository extends JpaRepository<Militar, UUID>{
    
}
