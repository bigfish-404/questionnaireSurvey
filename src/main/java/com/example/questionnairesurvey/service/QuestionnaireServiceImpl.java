package com.example.questionnairesurvey.service;

import com.example.questionnairesurvey.dao.QuestionnaireRepository;
import com.example.questionnairesurvey.entity.Questionnaire;
import com.example.questionnairesurvey.entity.QuestionnaireID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Optional<Questionnaire> findById(String company, String name) {
        return questionnaireRepository.findByCompanyAndName(company,name);}

}
