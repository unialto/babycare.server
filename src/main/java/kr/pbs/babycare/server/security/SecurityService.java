package kr.pbs.babycare.server.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Service
@PropertySource("classpath:security.properties")
@RequiredArgsConstructor
public class SecurityService {
    @Value("${babycare.security.token.key}")
    private String key;

    @PostConstruct
    private void init() {
        key = Base64.getEncoder().encodeToString(key.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(UserDetails userDetails) {
        return Jwts.builder().setClaims(new ObjectMapper().convertValue(userDetails, Map.class))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public UserDetails getUserDetails(HttpServletRequest request) {
        return getUserDetails(request.getHeader("X-AUTH-TOKEN"));
    }

    public UserDetails getUserDetails(String token) {
        if (ObjectUtils.isEmpty(token)) {
            return null;
        }

        return new ObjectMapper().convertValue(
                Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody()
                , UserDetails.class
        );
    }
}
