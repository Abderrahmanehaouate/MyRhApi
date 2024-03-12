package com.youcode.myrhapi.controllers;


import com.youcode.myrhapi.models.Dtos.ReponseDto;
import com.youcode.myrhapi.services.interfaces.ReponseService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reponses")
public class ReponseController {

    private final ReponseService reponseService;

    public ReponseController(ReponseService reponseService) {
        this.reponseService = reponseService;
    }

    @PostMapping("/create")
    public ReponseDto createReponse(@RequestBody ReponseDto reponseDto) {
        return reponseService.create(reponseDto);
    }

}
