package com.example.questionnairesurvey.controller;

import com.example.questionnairesurvey.entity.Questionnaire;
import com.example.questionnairesurvey.service.QuestionnaireService;
import com.example.questionnairesurvey.util.CreateWord;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private HttpSession session;

    @PostMapping ("/index")
    public String showQuestionnaire(HttpServletRequest request ) {
        String company = request.getParameter("company");
        String name = request.getParameter("name");

        session.setAttribute("company",company);
        session.setAttribute("name", name);

        return"index" ;
    }

    @PostMapping("/complete")
    public String submitQuestionnaire(HttpServletRequest request) throws IOException {

        String company = (String) session.getAttribute("company");
        String name = (String) session.getAttribute("name");
        String department = request.getParameter("department");
        String charge = request.getParameter("charge");
        String Q1_RADIO = request.getParameter("Q1_RADIO");
        String Q2_ANSWER_TEXT = request.getParameter("Q2_ANSWER_TEXT");
        String Q3_ANSWER_TEXT = request.getParameter("Q3_ANSWER_TEXT");

        Questionnaire questionnaire = new Questionnaire();

        questionnaire.setCompany(company);
        questionnaire.setName(name);
        questionnaire.setDepartment(department);
        questionnaire.setCharge(charge);
        questionnaire.setQ1_RADIO(Integer.parseInt(Q1_RADIO));
        questionnaire.setQ2_ANSWER_TEXT(Q2_ANSWER_TEXT);
        questionnaire.setQ3_ANSWER_TEXT(Q3_ANSWER_TEXT);

        questionnaireService.createQuestionnaire(questionnaire);
        CreateWord createWord = new CreateWord();
        createWord.createDocument(questionnaire);
        return "success";
    }

}
