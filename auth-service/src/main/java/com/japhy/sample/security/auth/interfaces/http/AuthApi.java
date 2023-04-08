package com.japhy.sample.security.auth.interfaces.http;

import com.japhy.sample.security.auth.interfaces.dto.LoginRequestDto;
import com.japhy.sample.security.auth.interfaces.dto.SignupUserDto;
import com.japhy.sample.security.auth.interfaces.dto.TokenDto;
import com.japhy.sample.security.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@RestController
public class AuthApi {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@RequestBody SignupUserDto signupUserDto) {
        authService.signup(signupUserDto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @GetMapping("/token")
    public ResponseEntity<TokenDto> reissueToken(
            @RequestHeader("authorization") String accessToken) {
        return ResponseEntity.ok(authService.reissueToken(accessToken));
    }

}
