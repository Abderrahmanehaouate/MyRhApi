package com.youcode.myrhapi.services.interfaces;

import com.youcode.myrhapi.models.Dtos.JobOfferDto.JobOfferDto;
import org.springframework.data.domain.Page;

import java.util.List;


public interface JobOfferService extends BaseService<JobOfferDto>{

    Page<JobOfferDto> getAllJobOffers(int page, int pageSize, String sortBy, String search);
}
