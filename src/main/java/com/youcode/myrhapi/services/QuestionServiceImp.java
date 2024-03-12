package com.youcode.myrhapi.services;

import com.youcode.myrhapi.models.Dtos.QuestionDto;
import com.youcode.myrhapi.models.Entities.Question;
import com.youcode.myrhapi.repositories.QuestionRepository;
import com.youcode.myrhapi.services.interfaces.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImp implements QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    public QuestionServiceImp(QuestionRepository questionRepository, ModelMapper modelMapper) {
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<QuestionDto> getAllQuestions(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        Page<Question> questions = questionRepository.findAll(pageRequest);
        return questions.map(question -> modelMapper.map(question, QuestionDto.class));
    }

    @Override
    public QuestionDto create(QuestionDto questionDto) {
        Question question = modelMapper.map(questionDto, Question.class);
        question = questionRepository.save(question);
        return modelMapper.map(question, QuestionDto.class);
    }


}
