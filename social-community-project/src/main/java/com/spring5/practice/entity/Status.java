package com.spring5.practice.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "story")
public class Story implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "st_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "privacy")
    private String privacy;

    @Column(name = "story_location")
    private Long storyLocation;

    @Column(name = "created_date_time")
    private LocalDateTime createdDateTime;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    // Usage for joinColumn when using OneToMany
//    @OneToOne(mappedBy = "story")
//    private Attachment attachment;


    // Usage for joinTable when using OneToMany
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "story_attachments",
            joinColumns = {@JoinColumn(name = "story_id", referencedColumnName = "st_id")},
            inverseJoinColumns = {@JoinColumn(name = "attachment_id", referencedColumnName = "at_id")}
    )
    private List<Attachment> statusAttachments = new ArrayList<>();


    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "l_id")
    private Location location;
}
