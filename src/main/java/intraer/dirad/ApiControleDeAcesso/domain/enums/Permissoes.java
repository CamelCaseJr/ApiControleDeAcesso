package intraer.dirad.ApiControleDeAcesso.domain.enums;

import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
public enum Permissoes {
    ADM(1),
    MASTER(2);
  
    private int tipo;
  
    Permissoes(int tipo){
      this.tipo = tipo;
    }
  
    public int getTipo() {
  
      return tipo;
  
    }

}
