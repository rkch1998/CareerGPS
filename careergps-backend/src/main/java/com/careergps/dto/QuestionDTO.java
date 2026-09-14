package com.careergps.dto;

import java.util.List;

public record QuestionDTO(
    Long questionId,
    String questionText,
    String questionType,
    Integer displayOrder,
    List<QuestionOptionDTO> options) {}
