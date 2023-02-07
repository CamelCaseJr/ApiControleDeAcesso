package intraer.dirad.ApiControleDeAcesso.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import intraer.dirad.ApiControleDeAcesso.models.Militar;

@Repository
public interface MilitarRepository extends JpaRepository<Militar, UUID>{
    
}
