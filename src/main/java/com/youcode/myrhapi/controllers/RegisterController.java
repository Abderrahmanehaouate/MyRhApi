package com.youcode.myrhapi.controllers;

import com.youcode.myrhapi.models.Dtos.AgentDto.AgentDto;
import com.youcode.myrhapi.models.Dtos.Authentification.AuthDto;
import com.youcode.myrhapi.models.Dtos.CompanyDto.CompanyDto;
import com.youcode.myrhapi.models.Dtos.CondidatDto.CondidatDto;
import com.youcode.myrhapi.security.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;

    public RegisterController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/condidat")
    public ResponseEntity<AuthDto> registerCondidat(@RequestBody CondidatDto authDto) {
        return ResponseEntity.ok(authService.registerCandidate(authDto));
    }

    @PostMapping("/company")
    public ResponseEntity<AuthDto> registerCompany(@RequestBody CompanyDto authDto) {
        return ResponseEntity.ok(authService.registerCompany(authDto));
    }

    @PostMapping("/agent")
    public ResponseEntity<AuthDto> registerAgent(@RequestBody AgentDto authDto) {
        return ResponseEntity.ok(authService.registerAgent(authDto));
    }
}
