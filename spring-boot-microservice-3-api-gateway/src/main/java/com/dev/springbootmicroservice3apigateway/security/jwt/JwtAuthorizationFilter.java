package com.dev.springbootmicroservice3apigateway.security.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    /**
     * To create a bean in SecurityConfig class to initialize this instance
     */
    @Autowired
    private JwtProvider jwtProvider;


    /**
     * @param request     from client
     * @param response    type HttpServletResponse to return some type data if alright success
     *                    process
     * @param filterChain filter every request to checks logic of security by JWT class
     * @throws ServletException exception to any ServletException
     * @throws IOException      In/Out Exception type
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = jwtProvider.getAuthentication(request);
        if (authentication != null && jwtProvider.isTokenValid(request)) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
