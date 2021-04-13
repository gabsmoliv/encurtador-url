package br.com.lancelot.encurtadorurl.service.abstracts;

import br.com.lancelot.encurtadorurl.model.response.UrlResponse;
import java.util.List;

/**
 * @author gabriel on 10/04/2021
 */
public interface UrlService {

    default List<UrlResponse> recuperarUrlsPorUsuario(String usuario) {

        return null;
    }

}
