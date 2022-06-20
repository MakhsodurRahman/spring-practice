package com.spring5.practice.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_table")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "textField")
    private String textField;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private Long phoneNumber;

    @Column(name = "ddSelectionOption")
    private String ddSelectionOption;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDdSelectionOption() {
        return ddSelectionOption;
    }

    public void setDdSelectionOption(String ddSelectionOption) {
        this.ddSelectionOption = ddSelectionOption;
    }
}
