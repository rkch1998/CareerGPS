package com.careergps.controller;

import com.careergps.dto.CareerCategoryDTO;
import com.careergps.service.CareerCategoryService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CareerCategoryController {

  private final CareerCategoryService careerCategoryService;

  public CareerCategoryController(CareerCategoryService careerCategoryService) {
    this.careerCategoryService = careerCategoryService;
  }

  @GetMapping("/categories")
  public List<CareerCategoryDTO> getAllCategories() {
    return careerCategoryService.getAllCategories();
  }
}
