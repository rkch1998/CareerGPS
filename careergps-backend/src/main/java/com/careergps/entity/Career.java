package com.careergps.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "careers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long careerId;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CareerCategory careerCategory;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "work_environment")
    private String workEnvironment;

    @Column(name = "reality_check")
    private String realityCheck;
}
