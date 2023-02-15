package intraer.dirad.ApiControleDeAcesso.enums;

import lombok.Getter;

@Getter
public enum TipoDeIdentificacao {

    BIOMETRIA(1),
    QRCODE(2),
    RFID(3),
    MANUAL(4);

    private int valor;

    TipoDeIdentificacao (int valor){
        this.valor = valor;
    }

    public int getValor() {

        return this.valor;
        
    }



}
