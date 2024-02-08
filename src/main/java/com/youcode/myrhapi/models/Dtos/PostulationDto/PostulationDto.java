package com.youcode.myrhapi.models.Dtos.PostulationDto;

import com.youcode.myrhapi.models.Dtos.CondidatDto.CondidatResponseDto;
import com.youcode.myrhapi.models.Dtos.JobOfferDto.JobOfferResponseDto;
import com.youcode.myrhapi.models.Entities.JobOffer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostulationDto {
    private Long id;
    private String cv;
    private boolean isActive;

    private JobOfferResponseDto jobOffer;
    private CondidatResponseDto candidate;

}
