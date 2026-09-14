package com.careergps.controller;

import com.careergps.dto.QuestionDTO;
import com.careergps.service.QuestionService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
  private final QuestionService questionService;

  public QuestionController(QuestionService questionService) {
    this.questionService = questionService;
  }

  @GetMapping
  public List<QuestionDTO> getQuestions() {
    return questionService.getActiveQuestions();
  }

  @GetMapping("/{id}")
  public QuestionDTO getQuestion(@PathVariable Long id) {
    return questionService.getQuestion(id);
  }
}
