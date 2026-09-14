package com.careergps.controller;

import com.careergps.dto.RouteDTO;
import com.careergps.service.CareerMapService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/careermap")
public class CareerMapController {
  private final CareerMapService careerMapService;

  public CareerMapController(CareerMapService careerMapService) {
    this.careerMapService = careerMapService;
  }

  @GetMapping("/{careerId}")
  public List<RouteDTO> getRoutes(@PathVariable Long careerId) {
    return careerMapService.getRoutes(careerId);
  }
}
