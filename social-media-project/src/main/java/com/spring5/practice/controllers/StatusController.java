package com.spring5.practice.controllers;

import com.spring5.practice.config.Properties;
import com.spring5.practice.config.Utils;
import com.spring5.practice.dao.AttachmentDAO;
import com.spring5.practice.dao.LocationDAO;
import com.spring5.practice.dao.StatusDAO;
import com.spring5.practice.dto.request.StatusRequestDto;
import com.spring5.practice.entity.Attachment;
import com.spring5.practice.entity.Location;
import com.spring5.practice.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class StatusController {

    @Autowired
    private LocationDAO locationDAO;
    @Autowired
    private StatusDAO statusDAO;
    @Autowired
    private AttachmentDAO attachmentDAO;

    @GetMapping("status/create")
    public String create(Model model){

        List<Location> locations = locationDAO.getAll();
        List<String> locationList = new ArrayList<>();

        for (Location location : locations) {
            locationList.add(location.getLocationName());
        }

        model.addAttribute("locationList", locationList);
        model.addAttribute("privacyList", Arrays.asList("Public", "Private"));
        model.addAttribute("status", new StatusRequestDto());
        return "status/create";
    }

    @PostMapping("status/store")
    public String store(Model model , @ModelAttribute("status") StatusRequestDto statusDto , @RequestParam("images")MultipartFile[] multipartFiles){

        Location location = locationDAO.getByName(statusDto.getLocation());

        List<Attachment> attachmentList = new ArrayList<>();

        for (MultipartFile file : multipartFiles) {
            Attachment attachment = Utils.saveFile(file, Properties.STATUS_FOLDER);
            if (attachment != null) {
                attachmentList.add(attachment);
            }
        }

        attachmentDAO.insertBulk(attachmentList);

        Status status = new Status();
        status.setTitle(statusDto.getTitle());
        status.setDescription(statusDto.getDescription());
        status.setPrivacy(statusDto.getPrivacy());
        status.setLocation(location);

        status.setStatusAttachmentList(attachmentList);



        statusDAO.insert(status);
        location.getStatuses().add(status);

        locationDAO.update(location);

        return "homepage";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("status/delete")
    public String delete(@RequestParam("statusId") Long id){

        statusDAO.delete(id);

        return "homepage";
    }

    @GetMapping("/")
    public String maintain(Model model){
        List<Status> statusList = statusDAO.getAll();
        //System.out.println(statusList.toString());
        model.addAttribute("statusList",statusList);

        return "homepage";
    }
}
