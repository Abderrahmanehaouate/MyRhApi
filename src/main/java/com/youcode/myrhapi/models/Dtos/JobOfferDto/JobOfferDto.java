package com.youcode.myrhapi.models.Dtos.JobOfferDto;

import com.youcode.myrhapi.models.Dtos.CompanyDto.CompanyResponseDto;
import com.youcode.myrhapi.models.Entities.Company;
import com.youcode.myrhapi.models.Enums.EducationLevel;
import com.youcode.myrhapi.models.Enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class JobOfferDto {
    private Long id;
    private String title;
    private String description;
    private String profile;
    private String city;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = true)
    private String salary;
    private CompanyResponseDto company;
}
