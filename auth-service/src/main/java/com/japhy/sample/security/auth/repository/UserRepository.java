package com.japhy.sample.security.auth.repository;

import com.japhy.sample.security.auth.entity.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    Long save(User user);

    Optional<User> findById(Long userId);

    User findUserByEmail(String email);
}
