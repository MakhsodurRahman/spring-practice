package com.spring5.practice.controllers;

import com.spring5.practice.dao.StudentDao;
import com.spring5.practice.entity.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @GetMapping("/create")
    public String create(Model model){
        List<String> departmentList = new  ArrayList(List.of("EEE","CSE","CIVIL"));
        model.addAttribute("title","Student Form");

        List<String> subjectList = new ArrayList(List.of("Bangla","English","Arabic"));
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("subjectList", subjectList);
        model.addAttribute("studentform", new StudentForm());

        return "create";
    }

    @PostMapping("/store")
    public String store(Model model , @ModelAttribute("studentform") StudentForm studentForm){

        studentDao.insert(studentForm);
        return "form-print";
    }

    @GetMapping("/maintain")
    public String maintain(Model model){

        List<StudentForm> studentFormList = studentDao.getAll();
        model.addAttribute("studentFormList", studentFormList);

        return "maintain";
    }
}
