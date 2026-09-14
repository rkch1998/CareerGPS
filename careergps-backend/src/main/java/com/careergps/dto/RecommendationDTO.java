package com.careergps.dto;

import java.util.List;

public record RecommendationDTO(
    String matchLevel,
    Long careerId,
    String careerName,
    String description,
    List<String> reasons) {}
