package com.japhy.sample.security.auth.service;

import com.japhy.sample.security.auth.infrastructure.TokenProvider;
import com.japhy.sample.security.auth.interfaces.dto.LoginRequestDto;
import com.japhy.sample.security.auth.interfaces.dto.SignupUserDto;
import com.japhy.sample.security.auth.interfaces.dto.TokenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final TokenProvider tokenProvider;

    private final UserService userService;

    private final DaoAuthenticationProvider daoAuthenticationProvider;

    public TokenDto login(LoginRequestDto loginRequestDto) {
        Authentication authentication = daoAuthenticationProvider.authenticate(
                UsernamePasswordAuthenticationToken.unauthenticated(loginRequestDto.email(),
                        loginRequestDto.password()));
        return tokenProvider.generateToken(authentication);
    }

    public void signup(final SignupUserDto signupUserDto) {
        userService.createUser(signupUserDto.toEntity());
    }
}
