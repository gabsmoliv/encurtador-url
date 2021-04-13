package br.com.lancelot.encurtadorurl.service.abstracts;

import br.com.lancelot.encurtadorurl.model.response.UrlResponse;

/**
 * @author gabriel on 08/04/2021
 */

public interface EncurtarUrlService {

    default String encurtarUrl(String url, Long idUsuario) {
        return null;
    }

    default String verificarUrlValida(String url) {
        return null;
    }

    default UrlResponse recuperarUrl(String url) {
        return null;
    }

}
