package com.spring5.practice.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "locations")
public class Location implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "location_name")
    private String locationName;

    @OneToMany(orphanRemoval = true, mappedBy = "location")
    private List<User> users = new ArrayList<>();

    @OneToMany(orphanRemoval = true, mappedBy = "location")
    private List<Status> statuses = new ArrayList<>();

}
