package com.japhy.sample.security.jwt.infrastructure;

/**
 * @author Japhy
 * @since 2023/3/12 04:02
 */

import com.japhy.sample.security.jwt.entity.User;
import java.util.Collections;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class JwtToUserConverter implements Converter<Jwt, UsernamePasswordAuthenticationToken> {

    @Override
    public UsernamePasswordAuthenticationToken convert(Jwt jwt) {
        User user = new User();
        user.setId(jwt.getSubject());
        user.setEmail(jwt.getClaim("email"));
        user.setName(jwt.getClaim("name"));
        return new UsernamePasswordAuthenticationToken(user, jwt, user.getAuthorities());
    }
}

