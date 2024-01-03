package com.youcode.myrhapi.services;

import com.youcode.myrhapi.models.Dtos.JobOfferDto.JobOfferDto;
import com.youcode.myrhapi.models.Entities.Company;
import com.youcode.myrhapi.models.Entities.JobOffer;
import com.youcode.myrhapi.repositories.CompanyRepository;
import com.youcode.myrhapi.repositories.JobOfferRepository;
import com.youcode.myrhapi.services.interfaces.JobOfferService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class JobOfferServiceImp implements JobOfferService {
    private final JobOfferRepository jobOfferRepository;
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    public JobOfferServiceImp(JobOfferRepository jobOfferRepository, CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.jobOfferRepository = jobOfferRepository;
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<JobOfferDto> getAllJobOffers(int page, int pageSize, String sortBy, String search) {
        String[] sortParams = sortBy.split(",");
        String sortField = sortParams[0];
        Sort.Direction sortDirection = Sort.Direction.ASC;

        if (sortParams.length > 1 && "desc".equalsIgnoreCase(sortParams[1])) {
            sortDirection = Sort.Direction.DESC;
        }
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(sortDirection, sortField));
        Page<JobOffer> jobOffers = jobOfferRepository.findAll(pageRequest);

        Page<JobOfferDto> jobOfferDtos = jobOffers.map((element) -> modelMapper.map(element, JobOfferDto.class));

        return jobOfferDtos;
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

        item.setCreatedAt(LocalDateTime.now());
        item.getCompany().getId();

        Company company = companyRepository.findById(item.getCompany().getId()).orElse(null);

        JobOffer jobOffer = modelMapper.map(item, JobOffer.class);
        jobOffer.setCompany(company);
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
