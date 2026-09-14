package com.careergps.service;

import com.careergps.dto.RecommendationDTO;
import com.careergps.entity.Career;
import com.careergps.repository.AssessmentAnswerRepository;
import com.careergps.repository.AssessmentRepository;
import com.careergps.repository.CareerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecommendationService {
    private final AssessmentAnswerRepository answerRepository;
    private final AssessmentRepository assessmentRepository;
    private final CareerRepository careerRepository;
    private final JdbcTemplate jdbcTemplate;

    public RecommendationService(AssessmentAnswerRepository answerRepository, AssessmentRepository assessmentRepository,
                                 CareerRepository careerRepository, JdbcTemplate jdbcTemplate) {
        this.answerRepository = answerRepository; this.assessmentRepository = assessmentRepository;
        this.careerRepository = careerRepository; this.jdbcTemplate = jdbcTemplate;
    }

    public List<RecommendationDTO> recommend(Long assessmentId) {
        if (!assessmentRepository.existsById(assessmentId)) throw new EntityNotFoundException("Assessment " + assessmentId + " was not found");
        if (answerRepository.findByAssessmentId(assessmentId).isEmpty()) throw new IllegalStateException("Answer at least one question before viewing recommendations");
        Map<Long, Integer> traitScores = studentTraitScores(assessmentId);
        List<ScoredCareer> scored = careerRepository.findAll().stream().map(career -> score(career, traitScores)).filter(item -> item.score > 0)
                .sorted(Comparator.comparingInt(ScoredCareer::score).reversed().thenComparing(item -> item.career.getName())).toList();
        List<RecommendationDTO> results = new ArrayList<>();
        for (int index = 0; index < scored.size(); index++) {
            String level = index < 3 ? "Strong Match" : index < 6 ? "Good Match" : "Worth Exploring";
            ScoredCareer item = scored.get(index);
            results.add(new RecommendationDTO(level, item.career.getCareerId(), item.career.getName(), item.career.getDescription(), item.reasons));
        }
        return results;
    }

    private Map<Long, Integer> studentTraitScores(Long assessmentId) {
        return jdbcTemplate.query("""
                SELECT qtm.trait_id, SUM(qtm.score) AS score
                FROM assessment_answers aa JOIN question_trait_mapping qtm ON qtm.option_id = aa.option_id
                WHERE aa.assessment_id = ? GROUP BY qtm.trait_id
                """, (rs, row) -> Map.entry(rs.getLong("trait_id"), rs.getInt("score")), assessmentId)
                .stream().collect(java.util.stream.Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private ScoredCareer score(Career career, Map<Long, Integer> studentTraitScores) {
        List<TraitWeight> weights = jdbcTemplate.query("""
                SELECT ctm.trait_id, ctm.weight, t.name FROM career_trait_mapping ctm
                JOIN traits t ON t.id = ctm.trait_id WHERE ctm.career_id = ?
                """, (rs, row) -> new TraitWeight(rs.getLong("trait_id"), rs.getInt("weight"), rs.getString("name")), career.getCareerId());
        int score = 0; List<String> reasons = new ArrayList<>();
        for (TraitWeight weight : weights) {
            if (studentTraitScores.getOrDefault(weight.traitId, 0) > 0) { score += studentTraitScores.get(weight.traitId) * weight.weight; reasons.add("You showed " + weight.name().toLowerCase() + " strengths"); }
        }
        return new ScoredCareer(career, score, reasons);
    }
    private record TraitWeight(Long traitId, int weight, String name) { }
    private record ScoredCareer(Career career, int score, List<String> reasons) { }
}
