package com.spring5.practice.controllers.scp;

import com.spring5.practice.dao.LocationDao;
import com.spring5.practice.entity.Location;
import com.spring5.practice.entity.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/scp")
public class LocationController {

    @Autowired
    private LocationDao locationDao;

    @GetMapping("/create-location")
    public String create(Model model){
        model.addAttribute("title","this is location form");
        model.addAttribute("location", new Location());
        return "create-location";
    }

    @PostMapping("/store3")
    public String store(Model model , @ModelAttribute("location") Location location){

        locationDao.insert(location);
        return "form-print";
    }


}
