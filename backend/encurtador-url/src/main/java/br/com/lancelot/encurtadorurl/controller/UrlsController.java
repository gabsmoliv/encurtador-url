package br.com.lancelot.encurtadorurl.controller;

import br.com.lancelot.encurtadorurl.model.request.UrlRequest;
import br.com.lancelot.encurtadorurl.model.response.UrlResponse;
import br.com.lancelot.encurtadorurl.service.impl.UrlServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {"/urls"})
public class UrlsController {

    private final UrlServiceImpl urlServico;

    UrlsController(UrlServiceImpl urlServico) {
        this.urlServico = urlServico;
    }

    @PostMapping
    public List<UrlResponse> recuperarUrls(@RequestBody UrlRequest urlRequest) {

        return urlServico.recuperarUrlsPorUsuario(urlRequest.getUsuario());
    }

}
