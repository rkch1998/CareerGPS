package com.careergps.service;

import com.careergps.dto.CareerCategoryDTO;
import com.careergps.entity.CareerCategory;
import com.careergps.repository.CareerCategoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CareerCategoryService {

  private final CareerCategoryRepository careerCategoryRepository;

  public CareerCategoryService(CareerCategoryRepository careerCategoryRepository) {
    this.careerCategoryRepository = careerCategoryRepository;
  }

  public List<CareerCategoryDTO> getAllCategories() {
    return careerCategoryRepository.findAll().stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  private CareerCategoryDTO convertToDTO(CareerCategory careerCategory) {
    return new CareerCategoryDTO(
        careerCategory.getCategoryId(), careerCategory.getName(), careerCategory.getDescription());
  }
}
