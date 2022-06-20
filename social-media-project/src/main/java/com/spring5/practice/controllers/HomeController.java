package com.spring5.practice.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


    }

