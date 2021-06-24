package br.com.lancelot.encurtadorurl.urls.service.implementations;

import static br.com.lancelot.encurtadorurl.util.Exceptions.onlyThrow;
import static br.com.lancelot.encurtadorurl.util.Constantes.URL_INVALID;

import br.com.lancelot.encurtadorurl.urls.service.interfaces.VerifyUrlService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@Service
public class VerifyUrlServiceImpl implements VerifyUrlService {

    @Override
    public String verifyIfUrlIsValid(String urlToValidate) {

        String urlValidated = verifyIfUrlStartsWithHttpOrHttps(urlToValidate);

        try {

            URL urlVerify = new URL(urlValidated);
            URLConnection conn = urlVerify.openConnection();
            conn.connect();

        } catch (IOException e) {
            onlyThrow(URL_INVALID);
        }

        return urlValidated;
    }

    @Override
    public String verifyIfUrlStartsWithHttpOrHttps(String urlToValidate) {

        boolean urlStartsHttpOrHttps = urlToValidate.startsWith("http://") || urlToValidate.startsWith("https://");

        if(!urlStartsHttpOrHttps){

            urlToValidate = urlToValidate.replace("www.", "");
            urlToValidate = "https://" + urlToValidate;
        }

        return urlToValidate;
    }
}
