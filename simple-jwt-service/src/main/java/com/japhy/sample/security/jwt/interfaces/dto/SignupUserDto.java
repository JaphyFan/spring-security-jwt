package com.japhy.sample.security.jwt.interfaces.dto;


import com.japhy.sample.security.jwt.entity.User;
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
