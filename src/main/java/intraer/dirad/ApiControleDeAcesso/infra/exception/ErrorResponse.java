package intraer.dirad.ApiControleDeAcesso.infra.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String exception;
    private String message;

    // Construtores, getters e setters
}
