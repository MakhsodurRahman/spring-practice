package com.spring5.practice.controllers;


import com.spring5.practice.dao.AttachmentDao;
import com.spring5.practice.dao.StoryDao;
import com.spring5.practice.dao.UserDao;
import com.spring5.practice.dao.UserTableDao;
import com.spring5.practice.entity.Attachment;
import com.spring5.practice.entity.Story;
import com.spring5.practice.entity.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RootController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AttachmentDao attachmentDao;

    @Autowired
    private UserTableDao userTableDao;

    @Autowired
    private StoryDao storyDao;

    @GetMapping
    public ModelAndView helloWorld() {
        this.initialize();
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "Mainul");
       // userDao.createUser();
        mv.setViewName("hello");
        return mv;
    }

    private void initialize() {
        UserTable  userTable = new UserTable();
        userTable.setId(System.currentTimeMillis());
        userTable.setEmail("abc@gmail.com");
        userTable.setName("ABC");

        Attachment attachment = new Attachment();
        attachment.setId(System.currentTimeMillis());
        attachment.setAttachmentPath("${user.home}/profile-picture-user1");
        attachment.setType(".jpg");
        // In case the Entity design is OneToMany with joinColumn
//        attachment.setStory                      (null);
        attachmentDao.save(attachment);

        userTable.setAttachment(attachment);
        userTableDao.save(userTable);


        Story story = new Story();
        story.setId(System.currentTimeMillis());
        story.setTitle("Story 1 by User 1");
        story.setUserTable(userTable);

        Attachment attachment1 = new Attachment();
        attachment1.setId(System.currentTimeMillis());
        attachment1.setAttachmentPath("${user.home}/att1");
        attachment1.setType(".jpg");
//         In case the Entity design is OneToMany with joinColumn
//        attachment1.setStory(story);
        attachmentDao.save(attachment1);

        Attachment attachment2 = new Attachment();
        attachment2.setId(System.currentTimeMillis());
        attachment2.setAttachmentPath("${user.home}/att2");
        attachment2.setType(".jpg");
        // In case the Entity design is OneToMany with joinColumn
//        attachment2.setStory(story);
        attachmentDao.save(attachment2);

        story.getStatusAttachments().add(attachment1);
        story.getStatusAttachments().add(attachment2);
        storyDao.save(story);

    }

    @GetMapping("/say-hello")
    public String helloName(Model model, @RequestParam(name = "name", defaultValue = "") String name) {
        model.addAttribute("name", name.isBlank() ? "World" : name);
        return "hello";
    }
}
