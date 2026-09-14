package com.careergps.repository;

import com.careergps.entity.Career;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
  List<Career> findByCareerCategoryCategoryIdOrderByNameAsc(Long categoryId);
}
