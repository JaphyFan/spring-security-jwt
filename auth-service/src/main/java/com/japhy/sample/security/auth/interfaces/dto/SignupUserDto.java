package com.japhy.sample.security.auth.interfaces.dto;


import com.japhy.sample.security.auth.entity.User;
import lombok.Builder;


@Builder
public record SignupUserDto(String email, String password, String name) {

    public User toEntity(){
        return User.builder()
                .email(email)
                .password(password)
                .name(name).build();
    }
}
