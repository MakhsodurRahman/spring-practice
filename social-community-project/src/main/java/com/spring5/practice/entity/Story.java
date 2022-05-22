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

    @Column(name = "locationId")
    private Long locationId;

    @Column(name = "createdDateTime")
    private LocalDateTime createdDateTime;

    @Column(name = "isDeleted")
    private Boolean isDeleted;

    // Usage for joinColumn when using OneToMany
//    @OneToOne(mappedBy = "story")
//    private Attachment attachment;


    // Usage for joinTable when using OneToMany
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "status_attachments",
            joinColumns = {@JoinColumn(name = "story_id", referencedColumnName = "st_id")},
            inverseJoinColumns = {@JoinColumn(name = "attachment_id", referencedColumnName = "at_id")}
    )
    private List<Attachment> statusAttachments = new ArrayList<>();


    @ManyToOne(targetEntity = UserTable.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserTable userTable;
}
