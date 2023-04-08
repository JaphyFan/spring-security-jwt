package com.japhy.sample.security.jwt.service;

import com.japhy.sample.security.jwt.infrastructure.TokenProvider;
import com.japhy.sample.security.jwt.interfaces.dto.LoginRequestDto;
import com.japhy.sample.security.jwt.interfaces.dto.SignupUserDto;
import com.japhy.sample.security.jwt.interfaces.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final TokenProvider tokenProvider;

    private final UserService userService;

    private final DaoAuthenticationProvider daoAuthenticationProvider;

    @Qualifier("jwtRefreshTokenAuthProvider")
    @Autowired
    private JwtAuthenticationProvider refreshTokenAuthProvider;

    public TokenDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = daoAuthenticationProvider.authenticate(
                UsernamePasswordAuthenticationToken.unauthenticated(loginRequestDto.email(),
                        loginRequestDto.password()));
        return tokenProvider.generateToken(authentication);
    }

    public void signup(final SignupUserDto signupUserDto) {
        userService.createUser(signupUserDto.toEntity());
    }

    public TokenDto reissueToken(TokenDto tokenDto) {
        Authentication authentication = refreshTokenAuthProvider.authenticate(
                new BearerTokenAuthenticationToken(tokenDto.getRefreshToken()));

        Jwt jwt = (Jwt) authentication.getCredentials();
        // check if present in db and not revoked, etc
        return tokenProvider.generateToken(authentication);
    }
}
