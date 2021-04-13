package br.com.lancelot.encurtadorurl.controller;

import br.com.lancelot.encurtadorurl.model.response.UrlResponse;
import br.com.lancelot.encurtadorurl.service.impl.EncurtarUrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gabriel on 08/04/2021
 */

@RestController
@RequestMapping(path = {"/"})
public class EncurtarUrlController {

    private final EncurtarUrlServiceImpl encurtarService;

    EncurtarUrlController(EncurtarUrlServiceImpl encurtarService) {
        this.encurtarService = encurtarService;
    }

    @PostMapping(path = {"encurtar"})
    public ResponseEntity<UrlResponse> encurtarUrl(@RequestParam("url") String url, @RequestParam("id_usuario") Long idUsuario) {

        String urlEncurtadaResponse = encurtarService.encurtarUrl(url, idUsuario);

        UrlResponse response = new UrlResponse();
        response.setUrlEncurtada("localhost:8080/"+ urlEncurtadaResponse);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "{urlEncurtada}")
    public ModelAndView encurtada(@PathVariable("urlEncurtada") String url) {

        UrlResponse urlResponse = encurtarService.recuperarUrl(url);

        return new ModelAndView("redirect:" + urlResponse.getUrlOriginal());
    }
}
