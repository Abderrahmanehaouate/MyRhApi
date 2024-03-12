package com.youcode.myrhapi.controllers;

import com.youcode.myrhapi.models.Dtos.QuestionDto;
import com.youcode.myrhapi.services.interfaces.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Page<QuestionDto> getQuestions(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int size) {
        return questionService.getAllQuestions(page, size);
    }

    @PostMapping("/create")
    public QuestionDto createQuestion(@RequestBody QuestionDto questionDto) {
        return questionService.create(questionDto);
    }

}
