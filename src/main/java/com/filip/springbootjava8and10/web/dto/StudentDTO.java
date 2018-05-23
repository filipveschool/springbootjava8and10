package com.filip.springbootjava8and10.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentDTO {

    private Long id;

    @NotNull(message = "NotNull.studentDTO.name")
    @Size(min = 1, max=64, message = "Size.studentDTO.name")
    private String name;

    private Character gender;

    private Float percentage;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, Character gender, Float percentage) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.percentage = percentage;
    }

    public Long getId() {
        return id;
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
