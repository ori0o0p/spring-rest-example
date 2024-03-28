package rest.project;

import io.jsonwebtoken.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;

@Component
public class TokenizerImpl implements Tokenizer {

    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(Date.valueOf(LocalDate.now()))
                .signWith(SignatureAlgorithm.HS256, "rest-project")
                .setExpiration(Date.valueOf(LocalDate.now().plusDays(1)))
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = createUserDetails(token);
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private UserDetails createUserDetails(String token) {
        String subject = Jwts.parser()
                .setSigningKey("rest-project")
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

        return new User(subject, "", Collections.emptyList());
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey("rest-project").parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

}
