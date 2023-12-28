package com.youcode.myrhapi.controllers;

import com.youcode.myrhapi.models.Dtos.JobOfferDto.JobOfferDto;
import com.youcode.myrhapi.services.interfaces.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public List<JobOfferDto> getAllJobOffers(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "2") int pageSize,
                                             @RequestParam(defaultValue = "id") String sortBy){

        return jobOfferService.getAllJobOffers(page, pageSize, sortBy);
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
