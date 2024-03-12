package com.youcode.myrhapi.services.interfaces;

import com.youcode.myrhapi.models.Dtos.ReponseDto;
import org.springframework.stereotype.Service;

@Service
public interface ReponseService {

    ReponseDto create(ReponseDto reponseDto);
}
