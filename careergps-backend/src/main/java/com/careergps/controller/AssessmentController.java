package com.careergps.controller;

import com.careergps.dto.*;
import com.careergps.service.AssessmentService;
import com.careergps.service.RecommendationService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/assessments")
public class AssessmentController {
  private final AssessmentService assessmentService;
  private final RecommendationService recommendationService;

  public AssessmentController(
      AssessmentService assessmentService, RecommendationService recommendationService) {
    this.assessmentService = assessmentService;
    this.recommendationService = recommendationService;
  }

  @PostMapping
  public AssessmentDTO create(@Valid @RequestBody CreateAssessmentRequest request) {
    return assessmentService.create(request);
  }

  @PostMapping("/{id}/answers")
  public AssessmentDTO saveAnswer(
      @PathVariable Long id, @Valid @RequestBody SaveAnswerRequest request) {
    return assessmentService.saveAnswer(id, request);
  }

  @GetMapping("/{id}/results")
  public List<RecommendationDTO> results(@PathVariable Long id) {
    return recommendationService.recommend(id);
  }
}
