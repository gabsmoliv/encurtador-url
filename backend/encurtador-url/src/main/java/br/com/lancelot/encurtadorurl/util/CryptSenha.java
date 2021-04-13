package br.com.lancelot.encurtadorurl.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author gabriel on 11/04/2021
 */
public class CryptSenha {

    public static BCryptPasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder(12);
    }
}
