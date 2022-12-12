package intraer.dirad.ApiControleDeAcesso.enums;

import javax.print.DocFlavor.STRING;

import lombok.Getter;
@Getter
public enum TipoContato {
  CELULAR(1),
  TELEFONEFIXO(2),
  EMAIL(3);

  private int tipo;

  TipoContato(int tipo){
    this.tipo = tipo;
  }

  public int getTipo() {

    return tipo;

  }




}
