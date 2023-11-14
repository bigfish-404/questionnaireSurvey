package com.example.questionnairesurvey.service;

import com.example.questionnairesurvey.entity.Questionnaire;

import java.util.Optional;
/*アンケートに関連するビジネスロジックを処理するため*/
public interface  QuestionnaireService {

    void createQuestionnaire(Questionnaire questionnaire);
    //受け取ったアンケートオブジェクトをデータベースに保存する責任があります

    Optional<Questionnaire> findById(String company,String name);
    //アンケートを検索するため,戻り値はOptional<Questionnaire>で、見つからない場合は 空のOptionalを返されます
}
