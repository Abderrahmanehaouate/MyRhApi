package com.youcode.myrhapi.services;

import com.youcode.myrhapi.models.Dtos.ReponseDto;
import com.youcode.myrhapi.models.Entities.Reponse;
import com.youcode.myrhapi.repositories.ReponseRepository;
import com.youcode.myrhapi.services.interfaces.ReponseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ReponseServiceImp implements ReponseService {

    private final ReponseRepository reponseRepository;
    private final ModelMapper modelMapper;

    public ReponseServiceImp(ReponseRepository reponseRepository, ModelMapper modelMapper) {
        this.reponseRepository = reponseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ReponseDto create(ReponseDto reponseDto) {
        Reponse reponse = modelMapper.map(reponseDto, Reponse.class);
        reponse = reponseRepository.save(reponse);
        return modelMapper.map(reponse, ReponseDto.class);
    }
}
