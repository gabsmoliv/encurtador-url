package br.com.lancelot.encurtadorurl.urls.service.interfaces;

import br.com.lancelot.encurtadorurl.urls.entity.Urls;

/**
 * @author gabriel on 08/04/2021
 */

public interface ShortenUrlService {

    Urls shortUrl(String url);

    Urls recoverUrl(String url);
}
