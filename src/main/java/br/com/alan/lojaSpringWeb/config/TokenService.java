package br.com.alan.lojaSpringWeb.config;

import br.com.alan.lojaSpringWeb.user.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("{$api.security.token.secret}")
    private String secret;
    public String geraToken(Usuario usuario){
        try {
            Algorithm algoritimo = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("autenticacao")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(geraDataExpiracao())
                    .sign(algoritimo);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token", exception);
        }
    }

    public String validaToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("autenticacao")
                    .build()
                    .verify(token)
                    .getSubject();

        }catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant geraDataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
