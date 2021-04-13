package br.com.lancelot.encurtadorurl.util;

public class Exceptions extends RuntimeException {

    public Exceptions(String mensagem){
        super(mensagem);
    }

    public Exceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public static void onlyThrow(String mensagemErro) throws Exceptions{
        throw new Exceptions(mensagemErro);
    }

    public static void checkAndThrow(boolean expression, String mensagemErro) throws Exceptions{

        if(expression) {
            throw new Exceptions(mensagemErro);
        }

    }

}
