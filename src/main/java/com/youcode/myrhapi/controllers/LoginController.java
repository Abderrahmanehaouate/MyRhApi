package com.youcode.myrhapi.controllers;

import com.youcode.myrhapi.models.Dtos.Authentification.AuthDto;
import com.youcode.myrhapi.models.Dtos.Authentification.LoginDto;
import com.youcode.myrhapi.security.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<AuthDto> login(@RequestBody LoginDto loginDto) {

        return ResponseEntity.ok(authService.login(loginDto));
    }
}
