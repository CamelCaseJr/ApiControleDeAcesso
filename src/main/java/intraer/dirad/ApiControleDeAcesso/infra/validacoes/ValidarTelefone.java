package intraer.dirad.ApiControleDeAcesso.infra.validacoes;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidacaoTelefone.class)
public @interface ValidarTelefone {
    String message() default "O número de telefone é inválido!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
