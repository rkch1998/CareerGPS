package com.careergps.service;

import com.careergps.dto.AssessmentDTO;
import com.careergps.dto.CreateAssessmentRequest;
import com.careergps.dto.SaveAnswerRequest;
import com.careergps.entity.Assessment;
import com.careergps.entity.AssessmentAnswer;
import com.careergps.entity.Question;
import com.careergps.entity.QuestionOption;
import com.careergps.repository.AssessmentAnswerRepository;
import com.careergps.repository.AssessmentRepository;
import com.careergps.repository.QuestionOptionRepository;
import com.careergps.repository.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AssessmentService {
  private final AssessmentRepository assessmentRepository;
  private final AssessmentAnswerRepository answerRepository;
  private final QuestionRepository questionRepository;
  private final QuestionOptionRepository optionRepository;

  public AssessmentService(
      AssessmentRepository assessmentRepository,
      AssessmentAnswerRepository answerRepository,
      QuestionRepository questionRepository,
      QuestionOptionRepository optionRepository) {
    this.assessmentRepository = assessmentRepository;
    this.answerRepository = answerRepository;
    this.questionRepository = questionRepository;
    this.optionRepository = optionRepository;
  }

  public AssessmentDTO create(CreateAssessmentRequest request) {
    Assessment assessment = new Assessment();
    assessment.setCurrentClass(request.currentClass());
    assessment.setStream(request.stream());
    assessment.setAge(request.age());
    assessmentRepository.save(assessment);
    return summary(assessment);
  }

  @Transactional
  public AssessmentDTO saveAnswer(Long assessmentId, SaveAnswerRequest request) {
    Assessment assessment =
        assessmentRepository
            .findById(assessmentId)
            .orElseThrow(() -> missing("Assessment", assessmentId));
    Question question =
        questionRepository
            .findById(request.questionId())
            .orElseThrow(() -> missing("Question", request.questionId()));
    QuestionOption option =
        optionRepository
            .findById(request.optionId())
            .orElseThrow(() -> missing("Option", request.optionId()));
    if (!option.getQuestion().getQuestionId().equals(question.getQuestionId()))
      throw new IllegalArgumentException("The selected option does not belong to this question");
    AssessmentAnswer answer =
        answerRepository
            .findByAssessmentIdAndQuestionQuestionId(assessmentId, request.questionId())
            .orElseGet(AssessmentAnswer::new);
    answer.setAssessment(assessment);
    answer.setQuestion(question);
    answer.setOption(option);
    answerRepository.save(answer);
    return summary(assessment);
  }

  private AssessmentDTO summary(Assessment assessment) {
    return new AssessmentDTO(
        assessment.getId(),
        assessment.getStatus(),
        answerRepository.findByAssessmentId(assessment.getId()).size());
  }

  private EntityNotFoundException missing(String type, Long id) {
    return new EntityNotFoundException(type + " " + id + " was not found");
  }
}
