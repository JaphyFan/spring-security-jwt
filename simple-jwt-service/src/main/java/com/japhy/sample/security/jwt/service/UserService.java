package com.japhy.sample.security.jwt.service;

import com.japhy.sample.security.jwt.entity.User;
import com.japhy.sample.security.jwt.repository.UserRepository;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

/**
 * @author Japhy
 * @since 2023/3/12 03:36
 */
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsManager {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @Override
    public void createUser(UserDetails user) {
        ((User) user).setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save((User) user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        User userByEmail = userRepository.findUserByEmail(username);
        return Objects.nonNull(userByEmail);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userByEmail = userRepository.findUserByEmail(username);
        return Optional.ofNullable(userByEmail)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户"));
    }
}
