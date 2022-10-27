package com.dev.springbootmicroservice3apigateway.controller;

import com.dev.springbootmicroservice3apigateway.model.Role;
import com.dev.springbootmicroservice3apigateway.security.UserPrincipal;
import com.dev.springbootmicroservice3apigateway.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //represent user current on application and send a token via request
    @PutMapping("change/{role}")
    public ResponseEntity<?> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal,
        @PathVariable final
        Role role) {
        userService.changeRole(role, userPrincipal.getUsername());
        return ResponseEntity.ok(true);
    }

    @GetMapping
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return new ResponseEntity<>(
            userService.findByUsernameReturnToken(userPrincipal.getUsername()),
            HttpStatus.OK);
    }
}
