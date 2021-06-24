package br.com.lancelot.encurtadorurl.util;

public class Constantes {

    public static final String ALLOWED_METHODS = "GET, POST, PUT, DELETE";

    public static final String ALLOWED_HEADERS = "Origin, Accept, X-Requestd-Wtih, Content-Type, Authorization";

    public static final String MAX_AGE = "3600";

    public static final String URL_PATH = "/urls";

    public static final String URL_SHORT = "/encurtar";

    public static final String URL_SHORTED = "/{urlEncurtada}";

    public static final String URL_INVALID = "URL inválida, verifique e tente novamente.";

    public static final String URL_NOT_FOUND = "URL não encontrada, verifque o link.";
}
