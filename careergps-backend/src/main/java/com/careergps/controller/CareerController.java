package com.careergps.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careergps.dto.CareerDTO;
import com.careergps.service.CareerService;

@RestController
@RequestMapping("/api/v1")
public class CareerController {

    private final CareerService careerService;

    public CareerController(CareerService careerService) {
        this.careerService = careerService;
    }

    @GetMapping("/careers")
    public List<CareerDTO> getAllCareers() {
        return careerService.getAllCareers();
    }

    @GetMapping("/careers/{id}")
    public ResponseEntity<CareerDTO> getCareerById(@PathVariable Long id) {
        return careerService.getCareerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/careers/category/{categoryId}")
    public List<CareerDTO> getCareersByCategory(@PathVariable Long categoryId) {
        return careerService.getCareersByCategory(categoryId);
    }
}
