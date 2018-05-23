package com.filip.springbootjava8and10.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.filip.springbootjava8and10.thymeleaf.utils.TeacherUtils;

@Controller
public class TeacherController {

    @GetMapping(value = "/listTeachers")
    public String getInfo(Model model){
        model.addAttribute("teachers", TeacherUtils.buildTeachers());

        return "pages/teachers/listTeachers";
    }

}
