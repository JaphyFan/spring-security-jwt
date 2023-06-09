package com.japhy.sample.security.auth.config;


import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;

@Configuration
public class JWTConfig {

    private final String KID = "e902868c-50ec-419c-a85a-1e181794577e";

    @Value("${jwt.access.public.key}")
    RSAPublicKey accessPubKey;

    @Value("${jwt.access.private.key}")
    RSAPrivateKey accessPriKey;

    @Bean
    @Primary
    JwtEncoder jwtEncoder() {
        return new NimbusJwtEncoder(jwkSource());
    }

    /**
     * 生成jwt的公钥和私钥.Authorization需要.
     * kid和密钥对保持一致，同一密钥对kid不变，不然web-service重启后会判断认证不通过
     * @return
     */
    @Bean
    public JWKSource<SecurityContext> jwkSource() {
        RSAKey rsaKey = new RSAKey.Builder(accessPubKey)
                .privateKey(accessPriKey)
                .keyID(KID)
                .build();
        JWKSet jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource());
    }

}
