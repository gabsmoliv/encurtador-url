package br.com.lancelot.encurtadorurl.urls.controller;

import static br.com.lancelot.encurtadorurl.util.Constantes.URL_PATH;
import static br.com.lancelot.encurtadorurl.util.Constantes.URL_SHORT;
import static br.com.lancelot.encurtadorurl.util.Constantes.URL_SHORTED;

import br.com.lancelot.encurtadorurl.urls.dto.response.UrlResponse;
import br.com.lancelot.encurtadorurl.urls.entity.Urls;
import br.com.lancelot.encurtadorurl.urls.mapper.UrlMapper;
import br.com.lancelot.encurtadorurl.urls.service.implementations.ShortenUrlServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author gabriel on 08/04/2021
 */

@RestController
@RequestMapping(path = {URL_PATH})
@AllArgsConstructor
public class UrlController {

    private final ShortenUrlServiceImpl shortenUrlService;

    private final UrlMapper urlMapper;

    @PostMapping(URL_SHORT)
    public ResponseEntity<UrlResponse> shortUrl(@RequestParam("url") String url) {

        Urls urlShorted = shortenUrlService.shortUrl(url);
        UrlResponse urlResponse = urlMapper.urlToUrlResponse(urlShorted);

        return ResponseEntity.ok().body(urlResponse);
    }

    @GetMapping(URL_SHORTED)
    public ResponseEntity<UrlResponse> recoverShortedUrl(@PathVariable("urlEncurtada") String url) {

        Urls urlRecovered = shortenUrlService.recoverUrl(url);
        UrlResponse urlResponse = urlMapper.urlToUrlResponse(urlRecovered);

        return ResponseEntity.ok().body(urlResponse);
    }
}
