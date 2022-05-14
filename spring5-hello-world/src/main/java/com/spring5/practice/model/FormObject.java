package com.spring5.practice.model;

public class FormObject {
    private String textField;
    private String date;
    private String ddSelectionOption;
    private String email;
    private Long phoneNumber;

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDdSelectionOption() {
        return ddSelectionOption;
    }

    public void setDdSelectionOption(String ddSelectionOption) {
        this.ddSelectionOption = ddSelectionOption;
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
}
