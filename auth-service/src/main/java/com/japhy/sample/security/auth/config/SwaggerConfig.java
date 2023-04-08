package com.japhy.sample.security.auth.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Japhy
 * @since 2021/1/10 09:35
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
                .info(new Info().title("Auth Service API")
                        .description("this is the Auth service api")
                        .version(appVersion)
                        .license(new License().name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("google")
                        .url("https://www.google.com"));
    }

}
