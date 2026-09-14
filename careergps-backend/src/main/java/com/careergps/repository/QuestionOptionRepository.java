package com.careergps.repository;

import com.careergps.entity.QuestionOption;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionOptionRepository extends JpaRepository<QuestionOption, Long> {
  List<QuestionOption> findByQuestionQuestionIdOrderByDisplayOrderAsc(Long questionId);
}
