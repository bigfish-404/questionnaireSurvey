package com.example.questionnairesurvey.dao;

import com.example.questionnairesurvey.entity.Questionnaire;
import com.example.questionnairesurvey.entity.QuestionnaireID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, QuestionnaireID> {
    //JpaRepository はSpring Data JPAが提供する基本的な CRUD 操作を含む汎用のインターフェースです。

    Optional<Questionnaire> findByCompanyAndName(String company, String name);
}
