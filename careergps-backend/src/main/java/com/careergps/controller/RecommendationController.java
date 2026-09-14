package com.careergps.controller;

import com.careergps.dto.RecommendationDTO;
import com.careergps.service.RecommendationService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/recommendations")
public class RecommendationController {
  private final RecommendationService recommendationService;

  public RecommendationController(RecommendationService recommendationService) {
    this.recommendationService = recommendationService;
  }

  @GetMapping("/{assessmentId}")
  public List<RecommendationDTO> getRecommendations(@PathVariable Long assessmentId) {
    return recommendationService.recommend(assessmentId);
  }
}
