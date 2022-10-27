package com.dev.springbootmicroservice3apigateway.security;

import com.dev.springbootmicroservice3apigateway.model.User;
import com.dev.springbootmicroservice3apigateway.service.UserService;
import com.dev.springbootmicroservice3apigateway.utils.SecurityUtils;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username)
            .orElseThrow(
                () -> new UsernameNotFoundException("The user could not be found: " + username));

        Set<GrantedAuthority> authorities = Set.of(
            SecurityUtils.convertToAuthority(user.getRole().name()));
        return UserPrincipal.builder()
            .id(user.getId())
            .user(user)
            .username(username)
            .password(user.getPassword())
            .authorities(authorities)
            .build();
    }
}
