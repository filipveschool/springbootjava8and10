package com.filip.springbootjava8and10.domain.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "Students")
public class Student implements Serializable {

    private static final long serialVersionUID = -8582553475226281591L;

    //@NotNull(message = "Student ID is required.")
    //@Min(value = 1000, message = "Student ID must be at least 4 digits.")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull(message = "Student name is required.")
    private String name;

    @Column(name = "gender")
    @NotNull(message = "Student gender is required.")
    private Character gender;

    @Column(name="percentage")
    private Float percentage;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
}
