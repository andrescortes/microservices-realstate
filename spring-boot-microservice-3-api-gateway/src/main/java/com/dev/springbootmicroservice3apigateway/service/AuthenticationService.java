package com.dev.springbootmicroservice3apigateway.service;

import com.dev.springbootmicroservice3apigateway.model.User;

public interface AuthenticationService {

    User signInAndReturnJWT(User signInRequest);
}
