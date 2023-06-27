package com.example.questionnairesurvey.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//コントローラークラスはHTTPリクエストを処理し、適切なビューまたはデータを返します
@Controller
public class LoginInputController {
    //ユーザーがルートパス”/”にアクセスすると、このメソッドが呼び出されます
    @GetMapping("/")
    public String getLogin(){
        return "login";
    }//この"login"はビュー名と解釈されます
}
