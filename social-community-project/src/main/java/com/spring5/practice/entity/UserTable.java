package com.spring5.practice.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "user_table")
public class UserTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "locationId")
    private Long locationId;

    @OneToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "at_id", referencedColumnName = "at_id")
    private Attachment attachment;

    @OneToMany(orphanRemoval = true, mappedBy = "userTable")
    private List<Story> stories;
}
