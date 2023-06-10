package com.example.questionnairesurvey.entity;

import jakarta.persistence.*;



@Entity
@Table(name= "answer")
public class Questionnaire {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    private int Q1_RADIO1;
    private int Q2_RADIO1;
    private int Q3_RADIO1;
    private int Q4_RADIO1;
    private String Q5_ANSWER_TEXT;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQ1_RADIO1() {
        return Q1_RADIO1;
    }

    public void setQ1_RADIO1(int q1_RADIO1) {
        Q1_RADIO1 = q1_RADIO1;
    }

    public int getQ2_RADIO1() {
        return Q2_RADIO1;
    }

    public void setQ2_RADIO1(int q2_RADIO1) {
        Q2_RADIO1 = q2_RADIO1;
    }

    public int getQ3_RADIO1() {
        return Q3_RADIO1;
    }

    public void setQ3_RADIO1(int q3_RADIO1) {
        Q3_RADIO1 = q3_RADIO1;
    }

    public int getQ4_RADIO1() {
        return Q4_RADIO1;
    }

    public void setQ4_RADIO1(int q4_RADIO1) {
        Q4_RADIO1 = q4_RADIO1;
    }

    public String getQ5_ANSWER_TEXT() {
        return Q5_ANSWER_TEXT;
    }

    public void setQ5_ANSWER_TEXT(String q5_ANSWER_TEXT) {
        Q5_ANSWER_TEXT = q5_ANSWER_TEXT;
    }
}
