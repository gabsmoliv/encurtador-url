package br.com.lancelot.encurtadorurl.util;

/**
 * @author gabriel on 09/04/2021
 */

public class Constantes {

    public static final String METODOS_PERMITIDOS = "GET, POST, PUT, DELETE";

    public static final String HEADERS_PERMITIDOS = "Origin, Accept, X-Requestd-Wtih, Content-Type, Authorization";

    public static final String MAX_AGE = "3600";

    public static final String URI_LOGIN = "/login";

    public static final String URI_USUARIOS = "/usuarios";

    public static final String VAZIO = "";

    public static final String URL_PATH = "/urls";

    public static final String URL_SHORT = "/encurtar";

    public static final String URL_SHORTED = "/{urlEncurtada}";

    public static final String URL_INVALIDA = "URL inválida, verifique e tente novamente.";

    public static final String URL_NAO_ENCONTRADO = "URL não encontrada, verifque o link.";

    public static final String REQUISICAO_NEGADA = "[NEGADO] Requesição sem token de identificação!";

}
