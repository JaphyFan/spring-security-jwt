package com.japhy.sample.security.auth.repository;

import com.japhy.sample.security.auth.entity.User;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> usersMap = new LinkedHashMap<>();
    private long id = 1L;

    @Override
    public Long save(User user) {
        this.usersMap.put(id, user);
        user.setId(String.valueOf(id));
        return id++;
    }

    @Override
    public Optional<User> findById(Long userId) {
        return Optional.ofNullable(this.usersMap.get(userId));
    }

    @Override
    public User findUserByEmail(String email) {
        return this.usersMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue().sameEmail(email))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("未找到用户"))
                .getValue();
    }
}
