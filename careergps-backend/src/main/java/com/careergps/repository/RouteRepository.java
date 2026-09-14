package com.careergps.repository;

import com.careergps.entity.Route;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
  List<Route> findByCareerCareerIdOrderByIdAsc(Long careerId);
}
