package com.spring5.practice.controllers;

import com.spring5.practice.dao.LocationDAO;
import com.spring5.practice.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationDAO locationDAO;
    @GetMapping("/create")
    public String create(Model model){
        Location location = new Location();
        model.addAttribute("location" , location);
        return "location/create";
    }

    @PostMapping("/store")
    public String store(Model model,@ModelAttribute("location") Location location){


        locationDAO.insert(location);
        model.addAttribute("location",location);
        return "location/show";
    }

    @GetMapping("/maintain")
    public String maintain(Model model){
       List<Location> locationList = locationDAO.getAll();
       model.addAttribute("locationList",locationList);
        return "location/maintain";
    }


}
