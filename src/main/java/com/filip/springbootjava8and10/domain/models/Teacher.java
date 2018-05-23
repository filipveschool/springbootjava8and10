package com.filip.springbootjava8and10.domain.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Teachers")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 946941572942270450L;

    //@NotNull(message = "Teacher ID is required.")
    //@Min(value = 1000, message = "Teacher ID must be at least 4 digits.")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotNull(message = "Teacher name is required.")
    private String name;

    @Column(name = "gender")
    @NotNull(message = "Teacher gender is required.")
    private Character gender;

    @Column(name = "isActive")
    private boolean isActive;

    @Transient
    //todo een relatie aanmaken en in SqL script steken en een entity genaamd course aanmaken
    private List<String> courses = new ArrayList<String>();

    @Column(name = "additionalSkills")
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

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
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
