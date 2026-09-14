package com.careergps.repository;

import com.careergps.entity.AssessmentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AssessmentAnswerRepository extends JpaRepository<AssessmentAnswer, Long> {
    List<AssessmentAnswer> findByAssessmentId(Long assessmentId);
    Optional<AssessmentAnswer> findByAssessmentIdAndQuestionQuestionId(Long assessmentId, Long questionId);
}
