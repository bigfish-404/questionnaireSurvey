package com.example.questionnairesurvey.service;

import com.example.questionnairesurvey.dao.QuestionnaireRepository;
import com.example.questionnairesurvey.entity.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Override
    public void createQuestionnaire(Questionnaire questionnaire) {
        questionnaireRepository.save(questionnaire);
    }

    @Override
    public Optional<Questionnaire> findById(int id) {
        return questionnaireRepository.findById((long) id);
    }

    @Override
    public Optional<Questionnaire> findByName(String name) {
        return questionnaireRepository.findByName(name);
    }


}
