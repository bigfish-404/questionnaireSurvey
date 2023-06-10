package com.example.questionnairesurvey.controller;

import com.example.questionnairesurvey.entity.Questionnaire;
import com.example.questionnairesurvey.service.QuestionnaireService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @GetMapping("/index")
    public String showQuestionnaire(HttpServletRequest request) {
        return"index" ;
    }
    @PostMapping ("/index")
    public String showQuestionnaire(HttpServletRequest request,@RequestParam("nameID") String name,@RequestParam("modelValue") int modelValue, Model model) {
        request.getSession().setAttribute("name",name);
        request.getSession().setAttribute("modelValue",modelValue);

        boolean disabled = false;
        boolean idExists = false;
        if (name != null && !name.isEmpty()) {
            Optional<Questionnaire> existingQuestionnaire = questionnaireService.findByName(name);
            if (existingQuestionnaire.isPresent()) {
                idExists = true;
                disabled = true;

                Questionnaire questionnaire = existingQuestionnaire.get();

                model.addAttribute("Q1_RADIO1Value", questionnaire.getQ1_RADIO1());
                model.addAttribute("Q2_RADIO1Value", questionnaire.getQ2_RADIO1());
                model.addAttribute("Q3_RADIO1Value", questionnaire.getQ3_RADIO1());
                model.addAttribute("Q4_RADIO1Value", questionnaire.getQ4_RADIO1());
                model.addAttribute("Q5_ANSWER_TEXT", questionnaire.getQ5_ANSWER_TEXT());
            }
        }

        model.addAttribute("disabled", disabled);
        model.addAttribute("idExists", idExists);
        model.addAttribute("modelValue",request.getSession().getAttribute("modelValue"));

        return "index";
    }

    @PostMapping("/complete")
    public String submitQuestionnaire(HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("name");
        String Q1_RADIO1 = request.getParameter("Q1_RADIO1");
        String Q2_RADIO1 = request.getParameter("Q2_RADIO1");
        String Q3_RADIO1 = request.getParameter("Q3_RADIO1");
        String Q4_RADIO1 = request.getParameter("Q4_RADIO1");
        String Q5_ANSWER_TEXT = request.getParameter("Q5_ANSWER_TEXT");

        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setName(name);
        questionnaire.setQ1_RADIO1(Integer.parseInt(Q1_RADIO1));
        questionnaire.setQ2_RADIO1(Integer.parseInt(Q2_RADIO1));
        questionnaire.setQ3_RADIO1(Integer.parseInt(Q3_RADIO1));
        questionnaire.setQ4_RADIO1(Integer.parseInt(Q4_RADIO1));
        questionnaire.setQ5_ANSWER_TEXT(Q5_ANSWER_TEXT);

        questionnaireService.createQuestionnaire(questionnaire);
        return "success";
    }
}
