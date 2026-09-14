package com.careergps.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long questionId;

    @Column(name = "question_text", nullable = false)
    private String questionText;

    @Column(name = "question_type")
    private String questionType;

    @Column(name = "display_order")
    private Integer displayOrder;

    @Column(name = "active", nullable = false)
    private Boolean active = true;
}
