package br.com.lancelot.encurtadorurl.service.impl;

import static br.com.lancelot.encurtadorurl.util.Exceptions.onlyThrow;
import static br.com.lancelot.encurtadorurl.util.Exceptions.checkAndThrow;
import static br.com.lancelot.encurtadorurl.util.Constantes.URL_NAO_ENCONTRADO;
import static br.com.lancelot.encurtadorurl.util.Constantes.USUARIO_NAO_ENCONTRADO;
import static br.com.lancelot.encurtadorurl.util.Constantes.URL_INVALIDA;

import br.com.lancelot.encurtadorurl.model.response.UrlResponse;
import br.com.lancelot.encurtadorurl.model.Urls;
import br.com.lancelot.encurtadorurl.model.Usuario;
import br.com.lancelot.encurtadorurl.repositories.UrlRepositorio;
import br.com.lancelot.encurtadorurl.repositories.UsuarioRepositorio;
import br.com.lancelot.encurtadorurl.service.abstracts.EncurtarUrlService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

/**
 * @author gabriel on 08/04/2021
 */

@Service
public class EncurtarUrlServiceImpl implements EncurtarUrlService {

    private final UrlRepositorio urlRepositorio;

    private final UsuarioRepositorio usuarioRepositorio;

    private EncurtarUrlServiceImpl(UrlRepositorio urlRepositorio, UsuarioRepositorio usuarioRepositorio) {
       this.urlRepositorio = urlRepositorio;
       this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public String encurtarUrl(String url, Long idUsuario) {

        //validar url
        String urlValidada = verificarUrlValida(url);

        Random gerarAleatorio = new Random();
        StringBuilder encurtada = new StringBuilder();

        //Url encurtada vai ter length de 6 e dependendo do valor aleatorio pode ter um numero, letra maiscula ou minuscula.
        for(int i = 0; i < 6; i++) {
            Double numeroSort = gerarAleatorio.nextDouble()*100;
            if(numeroSort.shortValue() < 10) {
                encurtada.append(numeroSort.shortValue());
            } else if (numeroSort.shortValue() >= 20 && numeroSort.shortValue() <= 50) {
                encurtada.append(Character.toUpperCase((char) ('a' + Math.abs(gerarAleatorio.nextInt() % 26))));
            } else {
                encurtada.append((char) ('a' + Math.abs(gerarAleatorio.nextInt() % 26)));
            }

        }

        //Recuperando usuario e checando se existe na base.
        Usuario usuarioRequest = usuarioRepositorio.findTopById(idUsuario);
        checkAndThrow(Objects.isNull(usuarioRequest), USUARIO_NAO_ENCONTRADO);

        //Montando persistencia
        Urls urlPersitence = Urls.builder()
                .usuario(usuarioRequest)
                .urlEncurtada(encurtada.toString())
                .urlOriginal(urlValidada)
                .dataOperacao(LocalDateTime.now())
                .build();

        //Persistindo
        urlRepositorio.save(urlPersitence);

        return encurtada.toString();
    }

    @Override
    public String verificarUrlValida(String url) {

        //Verificando se url tem http ou https
        boolean urlTemHttp = url.startsWith("http://") || url.startsWith("https://");

        if(!urlTemHttp){
            //Remover www e adicionar http://
            url = url.replace("www.", "");
            url = "https://" + url;
        }

        try {

            URL urlVerify = new URL(url);
            URLConnection conn = urlVerify.openConnection();
            conn.connect();

        } catch (IOException e) {
            onlyThrow(URL_INVALIDA);
        }

        return url;
    }

    @Override
    public UrlResponse recuperarUrl(String url) {

        Urls urlRecuperada = urlRepositorio.findByUrlEncurtada(url);
        checkAndThrow(Objects.isNull(urlRecuperada), URL_NAO_ENCONTRADO);

        return UrlResponse.builder()
                .urlEncurtada(urlRecuperada.getUrlEncurtada())
                .urlOriginal(urlRecuperada.getUrlOriginal())
                .build();
    }
}


