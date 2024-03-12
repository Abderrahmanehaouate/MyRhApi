package com.youcode.myrhapi.services;

import com.youcode.myrhapi.models.Dtos.CondidatDto.CondidatDto;
import com.youcode.myrhapi.models.Entities.Candidate;
import com.youcode.myrhapi.repositories.CandidateRepository;
import com.youcode.myrhapi.services.interfaces.CandidateService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImp implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final ModelMapper modelMapper;
    public CandidateServiceImp(CandidateRepository candidateRepository, ModelMapper modelMapper) {
        this.candidateRepository = candidateRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CondidatDto> getAll() {
        return null;
    }

    @Override
    public Optional<CondidatDto> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<CondidatDto> create(CondidatDto item) {
        Candidate candidate = modelMapper.map(item, Candidate.class);


        return Optional.of(modelMapper.map(this.candidateRepository.save(candidate), CondidatDto.class));
    }

    @Override
    public Optional<CondidatDto> update(CondidatDto item) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }
}
