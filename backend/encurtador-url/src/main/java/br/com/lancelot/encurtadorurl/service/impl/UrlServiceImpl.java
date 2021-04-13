package br.com.lancelot.encurtadorurl.service.impl;

import static br.com.lancelot.encurtadorurl.util.Exceptions.checkAndThrow;
import static br.com.lancelot.encurtadorurl.util.Constantes.USUARIO_NAO_ENCONTRADO;
import static br.com.lancelot.encurtadorurl.util.Constantes.URLS_NAO_ENCONTRADAS;
import br.com.lancelot.encurtadorurl.model.Urls;
import br.com.lancelot.encurtadorurl.model.Usuario;
import br.com.lancelot.encurtadorurl.model.response.UrlResponse;
import br.com.lancelot.encurtadorurl.repositories.UrlRepositorio;
import br.com.lancelot.encurtadorurl.repositories.UsuarioRepositorio;
import br.com.lancelot.encurtadorurl.service.abstracts.UrlService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author gabriel on 10/04/2021
 */

@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepositorio urlRepositorio;
    private final UsuarioRepositorio uusuarioRepositorio;

    UrlServiceImpl(UrlRepositorio urlRepositorio, UsuarioRepositorio usuarioRepositorio) {
        this.urlRepositorio = urlRepositorio;
        this.uusuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public List<UrlResponse> recuperarUrlsPorUsuario(String usuario) {

        Usuario userRequest = uusuarioRepositorio.findByUsuario(usuario);
        checkAndThrow(Objects.isNull(userRequest), USUARIO_NAO_ENCONTRADO);

        List<Urls> urlsRequest = urlRepositorio.findAllById(userRequest.getId());
        checkAndThrow(Objects.isNull(urlsRequest), URLS_NAO_ENCONTRADAS);

        List<UrlResponse> urlsResposta = new ArrayList<>();


        urlsRequest.forEach(urls -> {
            UrlResponse urlTemp = new UrlResponse();

            urlTemp.setId(urls.getId());
            urlTemp.setUrlOriginal(urls.getUrlOriginal());
            urlTemp.setUrlEncurtada(urls.getUrlEncurtada());
            urlTemp.setDataOperacao(urls.getDataOperacao().toString());

            urlsResposta.add(urlTemp);
        });

        return urlsResposta;
    }
}
