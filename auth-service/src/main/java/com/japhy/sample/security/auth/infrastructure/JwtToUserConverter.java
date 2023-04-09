package com.japhy.sample.security.auth.infrastructure;

/**
 * @author Japhy
 * @since 2023/3/12 04:02
 */

import com.japhy.sample.security.auth.entity.User;
import java.util.Collections;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class JwtToUserConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public JwtAuthenticationToken convert(Jwt jwt) {
        User user = new User();
        user.setId(jwt.getSubject());
        user.setEmail(jwt.getClaim("email"));
        return new JwtAuthenticationToken(jwt, Collections.emptyList(), user.getId());
    }
}

