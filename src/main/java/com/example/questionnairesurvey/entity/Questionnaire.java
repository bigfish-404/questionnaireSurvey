package com.example.questionnairesurvey.entity;

import jakarta.persistence.*;



@Entity
//このクラスをJPAエンティティとしてマークし、クラスがデータベースに永続さておきます
@Table(name= "answer")
//このエンティティをマッピングするためのデータベーステーブルの名前を指定し
@IdClass(QuestionnaireID.class)
//複合キークラスをしてイスつために使用されます、主キーが複数のフィールドで構成されていることを示します
public class Questionnaire {
    @Id
    private String company;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //generated 生产  基礎となるデータベースの自動増分主キーのメカニズム（结构）を使用することを示している
    private String  name;

    private String department;
    private String charge;
    private int Q1_RADIO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String Q2_ANSWER_TEXT;
    private String Q3_ANSWER_TEXT;


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public int getQ1_RADIO() { return Q1_RADIO;}

    public void setQ1_RADIO(int q1_RADIO) {
        Q1_RADIO = q1_RADIO;
    }

    public String getQ2_ANSWER_TEXT() {
        return Q2_ANSWER_TEXT;
    }

    public void setQ2_ANSWER_TEXT(String q2_ANSWER_TEXT) {
        Q2_ANSWER_TEXT = q2_ANSWER_TEXT;
    }

    public String getQ3_ANSWER_TEXT() {
        return Q3_ANSWER_TEXT;
    }

    public void setQ3_ANSWER_TEXT(String q3_ANSWER_TEXT) {
        Q3_ANSWER_TEXT = q3_ANSWER_TEXT;
    }

}
