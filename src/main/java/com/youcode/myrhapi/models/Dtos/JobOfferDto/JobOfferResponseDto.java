package com.youcode.myrhapi.models.Dtos.JobOfferDto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobOfferResponseDto {
    private Long id;
    private String title;
    private String description;
    private String profile;
    private String city;
    private String educationLevel;
    @Column(nullable = true)
    private String salary;
}
