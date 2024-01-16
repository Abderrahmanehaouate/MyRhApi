package com.youcode.myrhapi.controllers;

import com.youcode.myrhapi.models.Dtos.JobOfferDto.JobOfferDto;
import com.youcode.myrhapi.services.interfaces.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/jobOffers")
public class JobOfferController {
    private final JobOfferService jobOfferService;

    public JobOfferController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    @GetMapping
    public Page<JobOfferDto> getAllJobOffers(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "5") int size,
                                             @RequestParam (defaultValue = "id,desc") String sortBy,
                                             @RequestParam(defaultValue = "") String search){

        return jobOfferService.getAllJobOffers(page, size, sortBy, search);
    }

    @GetMapping("/{id}")
    public Optional<JobOfferDto> getJobOfferById(@PathVariable Long id){

        return jobOfferService.getById(id);
    }

    @PostMapping("/create")
    public Optional<JobOfferDto> createJobOffer(@RequestBody JobOfferDto jobOfferDto){

        return jobOfferService.create(jobOfferDto);
    }

    @PutMapping("/update")
    public Optional<JobOfferDto> updateJobOffer(@RequestBody JobOfferDto jobOfferDto){

        return jobOfferService.update(jobOfferDto);
    }
}
