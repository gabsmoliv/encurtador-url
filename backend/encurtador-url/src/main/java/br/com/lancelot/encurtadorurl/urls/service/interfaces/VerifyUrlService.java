package br.com.lancelot.encurtadorurl.urls.service.interfaces;

public interface VerifyUrlService {

    String verifyIfUrlIsValid(String urlToValidate);

    String verifyIfUrlStartsWithHttpOrHttps(String urlToValidate);

}
