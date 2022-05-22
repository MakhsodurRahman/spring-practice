package com.spring5.practice.controllers;

import com.spring5.practice.dao.UserDao;
import com.spring5.practice.entity.User;
import com.spring5.practice.model.FormObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class FormController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/create2")
    public String getForm(Model model){
       // FormObject formObject = new FormObject();
        model.addAttribute("pageTitle","precticing form jsp");
        model.addAttribute("userobj", new User());

        List<String> locations = new ArrayList<>();
        locations.add("Dhaka");
        locations.add("Khulna");
        locations.add("Barishal");
        locations.add("Rangpur");

        model.addAttribute("locationList",locations);

        return "form-elements";
    }

    @PostMapping("/store2")
    public String postForm(Model model , @ModelAttribute("userobj") User user){

//        list.add(formObject.getDdSelectionOption());
//        list.add(formObject.getEmail());
//        list.add(formObject.getPhoneNumber());
//        list.add(formObject.getTextField());
//        System.out.println(list.toString());
//        model.addAttribute("formPrint",formObject);
        userDao.createUser(user);

        return "null";
    }




}
