package com.example.questionnairesurvey.service;

import com.example.questionnairesurvey.entity.Questionnaire;

import java.util.Optional;

public interface  QuestionnaireService {
    void createQuestionnaire(Questionnaire questionnaire);

    Optional<Questionnaire> findById(int id);

    Optional<Questionnaire> findByName(String name);
}
