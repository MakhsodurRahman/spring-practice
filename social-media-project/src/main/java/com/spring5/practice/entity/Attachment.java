package com.spring5.practice.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "attachments")
public class Attachment implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "attachment_name")
    private String attachmentName;

    @Column(name = "attachment_path")
    private String attachmentPath;

    @Column(name = "attachment_type")
    private String  AttachmentType;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "attachment")
    private User user;

    // For joinColumn (OneToMay - ManyToOne)
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Story.class)
//    @JoinColumn(name = "stry_id", referencedColumnName = "st_id")
//    private Story story;
}
