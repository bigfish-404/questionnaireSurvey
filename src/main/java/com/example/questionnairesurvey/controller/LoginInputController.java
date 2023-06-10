package com.example.questionnairesurvey.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginInputController {
    @GetMapping("/")
    public String getLogin(){
        return "login";
    }
}
