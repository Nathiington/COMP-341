package com.example.examination;

public class User {
    private String firstName;
    private String lastName;
    private String nationalID;
    private String contactNumber;
    private String password;
    private String Role;

    public User(String firstName, String lastName, String nationalID, String contactNumber, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalID = nationalID;
        this.contactNumber = contactNumber;
        this.password = password;
        Role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}
