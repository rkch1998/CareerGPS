package com.careergps.dto;

import java.util.List;

public record RouteDTO(
    Long routeId,
    String routeName,
    String routeDescription,
    String routeType,
    Integer durationMonths,
    String costBand,
    String entranceExams,
    String competitionLevel,
    Boolean relocationNeeded,
    List<RouteStepDTO> steps) {}
