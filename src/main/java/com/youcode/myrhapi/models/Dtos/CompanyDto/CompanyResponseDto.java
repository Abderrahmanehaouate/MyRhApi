package com.youcode.myrhapi.models.Dtos.CompanyDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyResponseDto {
    private Long id;
    private String name;
    private String description;
    private String phone;
    private String email;
    private String login;
    private String image;
}
