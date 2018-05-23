package com.filip.springbootjava8and10.domain.models;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@Entity(name = "Teachers")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 946941572942270450L;

    @NotNull(message = "Teacher ID is required.")
    @Min(value = 1000, message = "Teacher ID must be at least 4 digits.")
    //@Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Teacher name is required.")
    private String name;

    @NotNull(message = "Teacher gender is required.")
    private String gender;

    private boolean isActive;

    private List<String> courses = new ArrayList<String>();

    private String additionalSkills;

    public Teacher() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public String getAdditionalSkills() {
        return additionalSkills;
    }

    public void setAdditionalSkills(String additionalSkills) {
        this.additionalSkills = additionalSkills;
    }
}
