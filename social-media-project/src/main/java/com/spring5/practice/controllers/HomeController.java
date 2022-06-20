package com.spring5.practice.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String homePage(){

        return "homepage";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/403")
    public String _403(){
        return "access-denied";
    }


}

