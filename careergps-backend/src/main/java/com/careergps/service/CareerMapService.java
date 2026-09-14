package com.careergps.service;

import com.careergps.dto.RouteDTO;
import com.careergps.repository.RouteRepository;
import com.careergps.repository.CareerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CareerMapService {
    private final RouteRepository routeRepository;
    private final CareerRepository careerRepository;
    public CareerMapService(RouteRepository routeRepository, CareerRepository careerRepository) { this.routeRepository = routeRepository; this.careerRepository = careerRepository; }
    public List<RouteDTO> getRoutes(Long careerId) {
        if (!careerRepository.existsById(careerId)) throw new EntityNotFoundException("Career " + careerId + " was not found");
        return routeRepository.findByCareerCareerIdOrderByIdAsc(careerId).stream()
                .map(route -> new RouteDTO(route.getId(), route.getRouteName(), route.getRouteDescription())).toList();
    }
}
