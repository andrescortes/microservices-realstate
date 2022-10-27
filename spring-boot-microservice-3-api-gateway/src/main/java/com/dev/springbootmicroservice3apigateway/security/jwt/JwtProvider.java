package com.dev.springbootmicroservice3apigateway.security.jwt;

import com.dev.springbootmicroservice3apigateway.model.User;
import com.dev.springbootmicroservice3apigateway.security.UserPrincipal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface JwtProvider {

    String generateToken(UserPrincipal auth);

    String generateToken(User user);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
