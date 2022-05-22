package com.spring5.practice.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Attachment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "at_id")
    private Long id;

    @Column(name = "attachmentName")
    private String attachmentName;

    @Column(name = "attachmentPath")
    private String attachmentPath;

    @Column(name = "type")
    private String type;

    @OneToOne(mappedBy = "attachment")
    private UserTable userTable;

    // For joinColumn (OneToMay - ManyToOne)
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Story.class)
//    @JoinColumn(name = "stry_id", referencedColumnName = "st_id")
//    private Story story;
}
