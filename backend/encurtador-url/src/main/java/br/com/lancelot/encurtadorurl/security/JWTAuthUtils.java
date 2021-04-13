package br.com.lancelot.encurtadorurl.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * @author gabriel on 11/04/2021
 */

@Component
public class JWTAuthUtils {

    private final String secret = "L0g1qU3_@s1St3m4aS_eNcurt4d0rUr1";

    Algorithm algo = Algorithm.HMAC256(secret);

    public String createToken(String subjectOfToken) {
        Date today = new Date();
        Date dateToExpire = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        return  JWT.create()
                .withSubject(subjectOfToken)
                .withExpiresAt(dateToExpire)
                .sign(algo);
    }

    public boolean verifyToken(String token) {
        JWTVerifier verifier = JWT.require(algo)
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return !jwt.getSubject().isEmpty() && !tokenIsExpired(jwt.getExpiresAt());
    }

    public Boolean tokenIsExpired(Date dateTokenExpire) {
        return dateTokenExpire.before(new Date());
    }

}
