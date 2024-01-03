package com.youcode.myrhapi.models.Dtos.PostulationDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostulationResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String cv;
}
