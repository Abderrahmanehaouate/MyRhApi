package com.youcode.myrhapi.services;

import com.youcode.myrhapi.models.Dtos.JobOfferDto.JobOfferDto;
import com.youcode.myrhapi.models.Entities.JobOffer;
import com.youcode.myrhapi.repositories.JobOfferRepository;
import com.youcode.myrhapi.services.interfaces.JobOfferService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobOfferServiceImp implements JobOfferService {
    private final JobOfferRepository jobOfferRepository;
    private final ModelMapper modelMapper;

    public JobOfferServiceImp(JobOfferRepository jobOfferRepository, ModelMapper modelMapper) {
        this.jobOfferRepository = jobOfferRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<JobOfferDto> getAllJobOffers(int page, int pageSize, String sortBy) {

        Page<JobOffer> jobOffers = jobOfferRepository.findAll(PageRequest.of(page, pageSize, Sort.by(sortBy)));

        return jobOffers.stream()
                .map(JobOffer -> modelMapper.map(JobOffer, JobOfferDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<JobOfferDto> getAll() {

        List<JobOffer> jobOffers = jobOfferRepository.findAll();

        return jobOffers.stream()
                .map(JobOffer -> modelMapper.map(JobOffer, JobOfferDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<JobOfferDto> getById(Long id) {

        JobOffer jobOffer = jobOfferRepository.findById(id).orElse(null);

        return Optional.ofNullable(modelMapper.map(jobOffer, JobOfferDto.class));
    }

    @Override
    public Optional<JobOfferDto> create(JobOfferDto item) {

        JobOffer jobOffer = modelMapper.map(item, JobOffer.class);
        JobOffer savedJobOffer = jobOfferRepository.save(jobOffer);

        return Optional.ofNullable(modelMapper.map(savedJobOffer, JobOfferDto.class));
    }

    @Override
    public Optional<JobOfferDto> update(JobOfferDto item) {

        JobOffer jobOffer = modelMapper.map(item, JobOffer.class);
        JobOffer savedJobOffer = jobOfferRepository.save(jobOffer);

        return Optional.ofNullable(modelMapper.map(savedJobOffer, JobOfferDto.class));
    }

    @Override
    public void deleteById(Long id) {
        jobOfferRepository.deleteById(id);
    }

}
