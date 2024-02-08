package com.youcode.myrhapi.models.Dtos.Authentification;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthDto {
    private String token;
    private String role;
}
