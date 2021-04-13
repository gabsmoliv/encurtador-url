package br.com.lancelot.encurtadorurl.security;

import static br.com.lancelot.encurtadorurl.util.Constantes.URI_LOGIN;
import static br.com.lancelot.encurtadorurl.util.Constantes.URI_USUARIOS;
import static br.com.lancelot.encurtadorurl.util.Constantes.REQUISICAO_NEGADA;
import static br.com.lancelot.encurtadorurl.util.Exceptions.onlyThrow;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Objects;

/**
 * @author gabriel on 09/04/2021
 */

@Component
@Order(1)
@Slf4j
public class RESTFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        JWTAuthUtils auth = new JWTAuthUtils();

       log.info("Começando uma trasanção em : {}", req.getRequestURI());
        if(URI_LOGIN.equals(req.getRequestURI()) || URI_USUARIOS.equals(req.getRequestURI())) {
            log.info("Commitando uma trasanção em : {}", req.getRequestURI());
            chain.doFilter(request, response);
        } else {

           String token = req.getHeader("Authorization");

            if(Objects.nonNull(token)) {
                if(auth.verifyToken(token)) {
                    chain.doFilter(request, response);
                    log.info("Commitando uma trasanção em : {}", req.getRequestURI());
                }

            } else {
                onlyThrow(REQUISICAO_NEGADA);
                log.error("Requesição sem token de identificação!");
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
