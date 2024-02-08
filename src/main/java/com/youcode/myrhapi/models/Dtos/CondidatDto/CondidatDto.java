package com.youcode.myrhapi.models.Dtos.CondidatDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CondidatDto {
    private Long id;
    private String firstName;
    private String password;
    private String lastName;
    private String email;
    private String phone;
}
