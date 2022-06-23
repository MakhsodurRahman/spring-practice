package com.spring5.practice.controllers;

import com.spring5.practice.config.Properties;
import com.spring5.practice.config.Utils;
import com.spring5.practice.dao.LocationDAO;
import com.spring5.practice.dao.UserDAO;
import com.spring5.practice.dto.request.UserRequestDto;
import com.spring5.practice.entity.Attachment;
import com.spring5.practice.entity.Location;
import com.spring5.practice.entity.User;
import com.spring5.practice.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LocationDAO locationDAO;
    @Autowired
    private UserDAO userDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/create")
    public String create(Model model){

        List<Location> locations = locationDAO.getAll();
        List<String> locationList = new ArrayList<>();

        for(Location location:locations){
            locationList.add(location.getLocationName());
        }

        List<String> roleList = Stream.of(Role.values())
                .map(Enum::name)
                .collect(Collectors.toList());

        model.addAttribute("roleList", roleList);
        model.addAttribute("userRequestDto", new UserRequestDto());
        model.addAttribute("locationList",locationList);

        return "user/create";
    }

    @PostMapping("/store")
    public String store(@Valid @ModelAttribute("userRequestDto")   UserRequestDto userRequestDto, BindingResult bindingResult, @RequestParam("image") MultipartFile multipartFile){

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult);
            return "user/create";
        }
        var user = new User();

        Attachment attachment = Utils.saveFile(multipartFile, Properties.USER_FOLDER);

        Location location = locationDAO.getByName(userRequestDto.getLocationName());

        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setRole(Role.valueOf(userRequestDto.getRole()));
        user.setLocation(location);
        user.setAttachment(attachment);

        userDAO.insert(user);

        location.getUsers().add(user);

        locationDAO.update(location);


        return "redirect:/user/maintain";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") Long theId){
        userDAO.delete(theId);
        return "redirect:/user/maintain";
    }
    @GetMapping("/maintain")
    public String maintain(Model model){
        List<User> userList = userDAO.getAll();
        model.addAttribute("userList", userList);
        return "user/maintain";
    }
}
