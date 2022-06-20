package com.spring5.practice.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_location")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ls_id")
    private Long id;

    @Column(name = "locationName")
    private String locationName;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "location")
    private  UserTable userTable;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "location")
    private Story story;


}
