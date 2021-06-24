package br.com.lancelot.encurtadorurl.urls.service.implementations;

import static br.com.lancelot.encurtadorurl.util.Exceptions.checkAndThrow;
import static br.com.lancelot.encurtadorurl.util.Constantes.URL_NOT_FOUND;

import br.com.lancelot.encurtadorurl.urls.entity.Urls;
import br.com.lancelot.encurtadorurl.urls.repository.UrlRepository;
import br.com.lancelot.encurtadorurl.urls.service.interfaces.ShortenUrlService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@Service
@AllArgsConstructor
public class ShortenUrlServiceImpl implements ShortenUrlService {

    private final UrlRepository urlRepository;

    private final VerifyUrlServiceImpl verifyUrlService;

    @Override
    public Urls shortUrl(String url) {

        String validatedUrl = verifyUrlService.verifyIfUrlIsValid(url);

        Random makeARandomNumber = new Random();
        StringBuilder shortedUrl = new StringBuilder();

        for(int i = 0; i < 6; i++) {
            int sortNumber = RandomUtils.nextInt(0, 100);
            if(sortNumber < 10) {
                shortedUrl.append(sortNumber);
            } else if (sortNumber >= 20 && sortNumber <= 50) {
                shortedUrl.append(Character.toUpperCase((char) ('a' + Math.abs(makeARandomNumber.nextInt() % 26))));
            } else {
                shortedUrl.append((char) ('a' + Math.abs(makeARandomNumber.nextInt() % 26)));
            }
        }

        Urls urlToPersist = new Urls();
        urlToPersist.setUrlOriginal(validatedUrl);
        urlToPersist.setUrlShorted(shortedUrl.toString());

        return urlRepository.save(urlToPersist);
    }

    @Override
    public Urls recoverUrl(String urlToRecover) {

        Urls urlRecovered = urlRepository.findByUrlShorted(urlToRecover);
        checkAndThrow(Objects.isNull(urlRecovered), URL_NOT_FOUND);

        return urlRecovered;
    }
}


