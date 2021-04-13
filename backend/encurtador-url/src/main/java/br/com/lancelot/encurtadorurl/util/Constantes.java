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

    public static final String USUARIO_CRIADO = "Usuário criado com sucesso!";

    public static final String USUARIO_BAD_REQUEST = "Verifque os dados da requisição e tente novamente";

    public static final String USUARIO_SENHA_INCORRETOS = "Senha incorreta.";

    public static final String USUARIO_VAZIO = "Usuario da requisição vazio, verifique os dados.";

    public static final String USUARIO_CADASTRADO = "Usuario já cadastrado!";

    public static final String URL_INVALIDA = "URL inválida, verifique e tente novamente.";

    public static final String URL_NAO_ENCONTRADO = "URL não encontrada, verifque o link.";

    public static final String URLS_NAO_ENCONTRADAS = "Não foi possivel achar nenhuma url.";

    public static final String USUARIO_NAO_ENCONTRADO = "Usuário informado não encontrado!";

    public static final String REQUISICAO_NEGADA = "[NEGADO] Requesição sem token de identificação!";

}
