package com.example.rankopo18000441;

public class Student {

    private String firstName;
    private String lastName;
    private String course;
    private String email;
    private String contactNumber;

    public Student(String firstName, String lastName, String course, String email, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.email = email;
        this.contactNumber = contactNumber;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
