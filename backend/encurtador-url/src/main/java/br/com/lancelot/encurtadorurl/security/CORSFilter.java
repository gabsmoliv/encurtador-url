package br.com.lancelot.encurtadorurl.security;

import static br.com.lancelot.encurtadorurl.util.Constantes.METODOS_PERMITIDOS;
import static br.com.lancelot.encurtadorurl.util.Constantes.HEADERS_PERMITIDOS;
import static br.com.lancelot.encurtadorurl.util.Constantes.MAX_AGE;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author gabriel on 09/04/2021
 */

@Component
@Order(0)
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;

        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Credentials", "false");
        res.setHeader("Access-Control-Allow-Methods", METODOS_PERMITIDOS);
        res.setHeader("Access-Control-Allow-Headers", HEADERS_PERMITIDOS);
        res.setHeader("Access-Control-Max-Age", MAX_AGE);

        if("OPTIONS".equalsIgnoreCase(((HttpServletRequest) request).getMethod())){
            res.setStatus(200);
        } else {
            chain.doFilter(request, res);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
