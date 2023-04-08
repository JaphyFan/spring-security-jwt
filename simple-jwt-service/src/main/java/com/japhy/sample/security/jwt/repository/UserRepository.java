package com.japhy.sample.security.jwt.repository;

import com.japhy.sample.security.jwt.entity.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    Long save(User user);

    Optional<User> findById(Long userId);

    User findUserByEmail(String email);
}
