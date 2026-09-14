package com.careergps.service;

import com.careergps.dto.RouteDTO;
import com.careergps.dto.RouteStepDTO;
import com.careergps.repository.CareerRepository;
import com.careergps.repository.RouteRepository;
import com.careergps.repository.RouteStepRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CareerMapService {
  private final RouteRepository routeRepository;
  private final CareerRepository careerRepository;
  private final RouteStepRepository routeStepRepository;

  public CareerMapService(
      RouteRepository routeRepository,
      CareerRepository careerRepository,
      RouteStepRepository routeStepRepository) {
    this.routeRepository = routeRepository;
    this.careerRepository = careerRepository;
    this.routeStepRepository = routeStepRepository;
  }

  public List<RouteDTO> getRoutes(Long careerId) {
    if (!careerRepository.existsById(careerId))
      throw new EntityNotFoundException("Career " + careerId + " was not found");
    return routeRepository.findByCareerCareerIdOrderByIdAsc(careerId).stream()
        .map(
            route ->
                new RouteDTO(
                    route.getId(),
                    route.getRouteName(),
                    route.getRouteDescription(),
                    route.getRouteType(),
                    route.getDurationMonths(),
                    route.getCostBand(),
                    route.getEntranceExams(),
                    route.getCompetitionLevel(),
                    route.getRelocationNeeded(),
                    routeStepRepository.findByRouteIdOrderByStepOrderAsc(route.getId()).stream()
                        .map(
                            step ->
                                new RouteStepDTO(
                                    step.getStepOrder(), step.getTitle(), step.getDetail()))
                        .toList()))
        .toList();
  }
}
