package com.careergps.repository;

import com.careergps.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findByCareerCareerIdOrderByIdAsc(Long careerId);
}
