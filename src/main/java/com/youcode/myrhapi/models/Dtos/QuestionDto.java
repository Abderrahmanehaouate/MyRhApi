package com.youcode.myrhapi.models.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionDto {
    private Long id;
    private String question;

    private List<ReponseDto> reponses;

}
