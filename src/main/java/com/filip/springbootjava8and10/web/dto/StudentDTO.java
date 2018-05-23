package com.filip.springbootjava8and10.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Student", description = "A student")
public class StudentDTO {

    @ApiModelProperty(value = "The unique identifier of the given student", readOnly = true)
    private Long id;

    @ApiModelProperty(value = "Name of the student", required = true)
    @NotNull(message = "NotNull.studentDTO.name")
    @Size(min = 1, max=64, message = "Size.studentDTO.name")
    private String name;

    @ApiModelProperty(value = "Indication if the student is a Male or Female")
    private Character gender;

    @ApiModelProperty(value = "Indication what the student got as a percentage score")
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
