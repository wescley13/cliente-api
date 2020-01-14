package br.com.surittec.clientes.commons;

import java.util.regex.Pattern;

public class ValidacaoUtils {

    public static final String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final Pattern PATTERN_EMAIL = Pattern.compile(EMAIL_REGEX);

    public static Boolean isEmailValido(String email){
        return isValido(email, PATTERN_EMAIL);
    }

    public static Boolean isValido(String info, Pattern patternAplicado){
        return info == null ? false : patternAplicado.matcher(info).matches();
    }
}
