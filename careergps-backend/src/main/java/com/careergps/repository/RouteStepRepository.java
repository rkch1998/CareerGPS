package com.careergps.repository;

import com.careergps.entity.RouteStep;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteStepRepository extends JpaRepository<RouteStep, Long> {
  List<RouteStep> findByRouteIdOrderByStepOrderAsc(Long routeId);
}
