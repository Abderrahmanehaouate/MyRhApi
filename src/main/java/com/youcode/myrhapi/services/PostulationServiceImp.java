package com.youcode.myrhapi.services;

import com.youcode.myrhapi.models.Dtos.PostulationDto.PostulationDto;
import com.youcode.myrhapi.models.Entities.Postulation;
import com.youcode.myrhapi.repositories.PostulationRepository;
import com.youcode.myrhapi.services.interfaces.PostulationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostulationServiceImp implements PostulationService {
    private final PostulationRepository postulationRepository;
    private final ModelMapper modelMpapper;
        public PostulationServiceImp(PostulationRepository postulationRepository, ModelMapper modelMpapper) {
            this.postulationRepository = postulationRepository;
            this.modelMpapper = modelMpapper;
        }


    @Override
    public List<PostulationDto> getAll() {
        List<Postulation> postulations = postulationRepository.findAll();
        return postulations.stream()
                .map(Postulation -> modelMpapper.
                        map(Postulation, PostulationDto.class)).
                collect(Collectors.toList());
    }

    @Override
    public Optional<PostulationDto> getById(Long id) {
            return postulationRepository.findById(id).map(Postulation -> modelMpapper.map(Postulation, PostulationDto.class));
    }

    @Override
    public Optional<PostulationDto> create(PostulationDto item) {
        Postulation postulation = modelMpapper.map(item, Postulation.class);
        Postulation postulationCreated = postulationRepository.save(postulation);
        return Optional.of(modelMpapper.map(postulationCreated, PostulationDto.class));
    }

    @Override
    public Optional<PostulationDto> update(PostulationDto item) {
            Postulation postulation = modelMpapper.map(item, Postulation.class);
            Postulation postulationUpdated = postulationRepository.save(postulation);
            return Optional.of(modelMpapper.map(postulationUpdated, PostulationDto.class));
    }

    @Override
    public void deleteById(Long id) {
            postulationRepository.deleteById(id);
    }
}
