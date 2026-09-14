package com.careergps.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.careergps.dto.CareerDTO;
import com.careergps.entity.Career;
import com.careergps.repository.CareerRepository;

@Service
public class CareerService {

    private final CareerRepository careerRepository;

    public CareerService(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    public List<CareerDTO> getAllCareers() {
        return careerRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<CareerDTO> getCareerById(Long careerId) {
        return careerRepository.findById(careerId)
                .map(this::convertToDTO);
    }

    public List<CareerDTO> getCareersByCategory(Long categoryId) {
        return careerRepository.findByCareerCategoryCategoryIdOrderByNameAsc(categoryId)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    private CareerDTO convertToDTO(Career career) {
        return new CareerDTO(
                career.getCareerId(),
                career.getCareerCategory().getCategoryId(),
                career.getName(),
                career.getDescription(),
                career.getWorkEnvironment(),
                career.getRealityCheck()
        );
    }
}
