package com.careergps.service;

import com.careergps.dto.QuestionDTO;
import com.careergps.dto.QuestionOptionDTO;
import com.careergps.entity.Question;
import com.careergps.repository.QuestionOptionRepository;
import com.careergps.repository.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionOptionRepository optionRepository;

    public QuestionService(QuestionRepository questionRepository, QuestionOptionRepository optionRepository) {
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
    }

    public List<QuestionDTO> getActiveQuestions() {
        return questionRepository.findByActiveTrueOrderByDisplayOrderAsc().stream().map(this::toDto).toList();
    }

    public QuestionDTO getQuestion(Long id) {
        return questionRepository.findById(id).filter(Question::getActive)
                .map(this::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Question " + id + " was not found"));
    }

    private QuestionDTO toDto(Question question) {
        var options = optionRepository.findByQuestionQuestionIdOrderByDisplayOrderAsc(question.getQuestionId())
                .stream().map(option -> new QuestionOptionDTO(option.getOptionId(), option.getOptionText(), option.getDisplayOrder())).toList();
        return new QuestionDTO(question.getQuestionId(), question.getQuestionText(), question.getQuestionType(), question.getDisplayOrder(), options);
    }
}
