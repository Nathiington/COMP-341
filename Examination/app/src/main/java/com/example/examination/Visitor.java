package com.example.examination;

public class Visitor {
    private String firstName;
    private String lastName;
    private String temperature;
    private String contactNumber;
    private String dateOfVisit;

    public Visitor(){};

    public Visitor(String firstName, String lastName, String temperature, String contactNumber, String dateOfVisit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.temperature = temperature;
        this.contactNumber = contactNumber;
        this.dateOfVisit = dateOfVisit;
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

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(String dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }
}
