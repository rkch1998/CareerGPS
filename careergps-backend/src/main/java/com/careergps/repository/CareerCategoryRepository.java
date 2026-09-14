package com.careergps.repository;

import com.careergps.entity.CareerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerCategoryRepository extends JpaRepository<CareerCategory, Long> {}
