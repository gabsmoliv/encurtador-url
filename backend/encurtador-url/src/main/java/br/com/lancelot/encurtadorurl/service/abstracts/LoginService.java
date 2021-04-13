package br.com.lancelot.encurtadorurl.service.abstracts;

import java.util.LinkedHashMap;

/**
 * @author gabriel on 08/04/2021
 */


public interface LoginService {

    default LinkedHashMap<String, Object> logar(String usuario, String senha) {

        return null;
    }

}
