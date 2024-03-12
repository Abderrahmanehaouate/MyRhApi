package com.youcode.myrhapi.services.interfaces;

import com.youcode.myrhapi.models.Dtos.QuestionDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface QuestionService {

    Page<QuestionDto> getAllQuestions(int page, int size);

    QuestionDto create(QuestionDto questionDto);
}
