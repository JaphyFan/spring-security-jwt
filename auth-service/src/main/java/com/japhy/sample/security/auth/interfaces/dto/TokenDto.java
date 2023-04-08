package com.japhy.sample.security.auth.interfaces.dto;

/**
 * @author Japhy
 * @since 2023/3/12 04:22
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
    private String userId;
    private String accessToken;
    private String refreshToken;
}
