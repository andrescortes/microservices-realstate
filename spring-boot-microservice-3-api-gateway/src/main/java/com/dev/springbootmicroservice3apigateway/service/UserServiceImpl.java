package com.dev.springbootmicroservice3apigateway.service;

import com.dev.springbootmicroservice3apigateway.model.Role;
import com.dev.springbootmicroservice3apigateway.model.User;
import com.dev.springbootmicroservice3apigateway.repository.UserRepository;
import com.dev.springbootmicroservice3apigateway.security.jwt.JwtProvider;
import java.time.LocalDateTime;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    private final JwtProvider jwtProvider;

    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder,
        JwtProvider jwtProvider) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateDate(LocalDateTime.now());

        User userCreated = repository.save(user);
        String jwt = jwtProvider.generateToken(userCreated);
        userCreated.setToken(jwt);
        return userCreated;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Transactional
    @Override
    public void changeRole(Role newRole, String username) {
        repository.updateUserRole(username, newRole);
    }

    @Override
    public User findByUsernameReturnToken(String username) {
        User user =
            repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User no found: " + username));
        String jwt = jwtProvider.generateToken(user);
        user.setToken(jwt);
        return user;
    }
}
