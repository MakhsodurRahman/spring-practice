package com.spring5.practice.controllers;

import com.spring5.practice.model.FormObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/form")
public class FormController {
    List<Object> list = new ArrayList();
    @GetMapping
    public String getForm(Model model){
        FormObject formObject = new FormObject();
        model.addAttribute("pageTitle","precticing form jsp");
        model.addAttribute("formObj", formObject);

        List<String> locations = new ArrayList<>();
        locations.add("Dhaka");
        locations.add("Khulna");
        locations.add("Barishal");
        locations.add("Rangpur");

        model.addAttribute("locationList",locations);

        return "form-elements";
    }

    @PostMapping
    public String postForm(Model model , @ModelAttribute("formobj") FormObject formObject){

        list.add(formObject.getDdSelectionOption());
        list.add(formObject.getEmail());
        list.add(formObject.getPhoneNumber());
        list.add(formObject.getTextField());
        System.out.println(list.toString());
        model.addAttribute("formPrint",formObject);
        return "form-print";
    }


}
