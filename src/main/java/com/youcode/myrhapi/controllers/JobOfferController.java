package com.youcode.myrhapi.controllers;

import com.youcode.myrhapi.models.Dtos.JobOfferDto.JobOfferDto;
import com.youcode.myrhapi.services.interfaces.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/v1/jobOffers")
public class JobOfferController {
    private final JobOfferService jobOfferService;

    @Autowired
    public JobOfferController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    @GetMapping
    public Iterable<JobOfferDto> getAllJobOffers(){

        return jobOfferService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<JobOfferDto> getJobOfferById(@PathVariable Long id){

        return jobOfferService.getById(id);
    }

    @GetMapping("/create")
    public Optional<JobOfferDto> createJobOffer(@RequestBody JobOfferDto jobOfferDto){

        return jobOfferService.create(jobOfferDto);
    }

    @GetMapping("/update")
    public Optional<JobOfferDto> updateJobOffer(@RequestBody JobOfferDto jobOfferDto){

        return jobOfferService.update(jobOfferDto);
    }

}
