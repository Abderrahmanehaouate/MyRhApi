package com.youcode.myrhapi.models.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReponseDto {

    private String reponse;
    private boolean isCorrect;

    private Long questionId;
}
