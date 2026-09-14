package com.careergps.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "routes")
@Getter
@Setter
@NoArgsConstructor
public class Route {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "career_id", nullable = false)
  private Career career;

  @Column(name = "route_name")
  private String routeName;

  @Column(name = "route_description")
  private String routeDescription;

  @Column(name = "route_type")
  private String routeType;

  @Column(name = "duration_months")
  private Integer durationMonths;

  @Column(name = "cost_band")
  private String costBand;

  @Column(name = "entrance_exams")
  private String entranceExams;

  @Column(name = "competition_level")
  private String competitionLevel;

  @Column(name = "relocation_needed")
  private Boolean relocationNeeded;
}
