package intraer.dirad.ApiControleDeAcesso.infra.validacoes;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidacaoTelefone implements ConstraintValidator<ValidarTelefone, String> {

    @Override
    public boolean isValid(String telefone, ConstraintValidatorContext context) {

        Pattern cel = Pattern.compile("\\d{2}\\d{9}");
        Pattern fix = Pattern.compile("\\d{2}\\d{8}");
        Matcher celular = cel.matcher(telefone.trim());
        Matcher fixo = fix.matcher(telefone.trim());

        return celular.matches() || fixo.matches();
    }
}
