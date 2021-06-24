package br.com.lancelot.encurtadorurl.util;

public class Exceptions extends RuntimeException {

    public Exceptions(String message){
        super(message);
    }

    public static void onlyThrow(String errorMessage) throws Exceptions{
        throw new Exceptions(errorMessage);
    }

    public static void checkAndThrow(boolean expression, String errorMessage) throws Exceptions{
        if(expression) {
            throw new Exceptions(errorMessage);
        }
    }
}
