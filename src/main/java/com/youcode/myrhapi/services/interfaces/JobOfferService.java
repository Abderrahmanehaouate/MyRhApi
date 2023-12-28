package com.youcode.myrhapi.services.interfaces;

import com.youcode.myrhapi.models.Dtos.JobOfferDto.JobOfferDto;

import java.util.List;


public interface JobOfferService extends BaseService<JobOfferDto>{

    List<JobOfferDto> getAllJobOffers(int page, int pageSize, String sortBy);
}
