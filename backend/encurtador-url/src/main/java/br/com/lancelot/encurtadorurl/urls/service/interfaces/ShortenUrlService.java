package br.com.lancelot.encurtadorurl.urls.service.interfaces;

import br.com.lancelot.encurtadorurl.urls.entity.Urls;

public interface ShortenUrlService {

    Urls shortUrl(String url);

    Urls recoverUrl(String url);
}
