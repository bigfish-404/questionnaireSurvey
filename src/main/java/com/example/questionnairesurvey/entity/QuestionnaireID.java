package com.example.questionnairesurvey.entity;

import java.io.Serializable;

public class QuestionnaireID implements Serializable {

    public QuestionnaireID() {
    }

    private  String company;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QuestionnaireID(String company, String id) {
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }



}
