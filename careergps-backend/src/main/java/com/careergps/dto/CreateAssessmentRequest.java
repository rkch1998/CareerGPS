package com.careergps.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAssessmentRequest(
    @NotBlank String currentClass, String stream, @NotNull Integer age) {}
