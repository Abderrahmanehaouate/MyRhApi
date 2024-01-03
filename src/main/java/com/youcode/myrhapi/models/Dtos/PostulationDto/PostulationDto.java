package com.youcode.myrhapi.models.Dtos.PostulationDto;

import com.youcode.myrhapi.models.Dtos.JobOfferDto.JobOfferResponseDto;
import com.youcode.myrhapi.models.Entities.JobOffer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostulationDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String cv;

    private JobOfferResponseDto jobOffer;

}
