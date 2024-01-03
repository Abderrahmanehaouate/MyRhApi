package com.youcode.myrhapi.controllers;

import com.youcode.myrhapi.models.Dtos.PostulationDto.PostulationDto;
import com.youcode.myrhapi.services.PostulationServiceImp;
import com.youcode.myrhapi.services.interfaces.PostulationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/postulations")
public class PostulationController {
    private final PostulationService postulationService;
    public PostulationController(PostulationServiceImp postulationServiceImp) {
        this.postulationService = postulationServiceImp;
    }

    @GetMapping
    public List<PostulationDto> getPostulations(){
        return postulationService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<PostulationDto> getPostulationById(@RequestParam Long id){
        return postulationService.getById(id);
    }
    @PostMapping("/create")
    public Optional<PostulationDto> createPostulation(@RequestBody PostulationDto postulationDto){
        return postulationService.create(postulationDto);
    }

}
