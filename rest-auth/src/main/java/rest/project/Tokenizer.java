package rest.project;

import org.springframework.security.core.Authentication;

public interface Tokenizer {
    String generateToken(String email);
    Authentication getAuthentication(String token);
    boolean validateToken(String token);

}
