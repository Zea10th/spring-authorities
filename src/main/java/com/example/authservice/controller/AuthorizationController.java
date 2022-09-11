package com.example.authservice.controller;

import com.example.authservice.exceptions.InvalidCredentials;
import com.example.authservice.exceptions.UnauthorizedUser;
import com.example.authservice.model.Authorities;
import com.example.authservice.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    private String resolveInvalidCredentials(InvalidCredentials exception) {
        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    private String resolveUnauthorizedUser(UnauthorizedUser exception) {
        System.out.println(exception.toString());
        return exception.getMessage();
    }
}