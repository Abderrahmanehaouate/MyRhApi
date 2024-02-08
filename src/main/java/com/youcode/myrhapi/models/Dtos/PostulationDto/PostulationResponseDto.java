package com.youcode.myrhapi.models.Dtos.PostulationDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostulationResponseDto {
    private Long id;
    private String cv;
    private boolean isActive;
}
