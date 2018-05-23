package com.filip.springbootjava8and10.controllers;

import com.filip.springbootjava8and10.domain.models.Student;
import com.filip.springbootjava8and10.thymeleaf.utils.StudentUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {

    @PostMapping(value = "/saveStudent")
    public String saveStudent(@Valid @ModelAttribute Student student, BindingResult errors, Model model){
        if(!errors.hasErrors()){
            // get mock objects
            List<Student> students = StudentUtils.buildStudents();
            // add current student
            students.add(student);
            model.addAttribute("students",students);
        }

        return ((errors.hasErrors()) ? "pages/students/addStudent" : "pages/students/listStudents");
    }

    @GetMapping(value = "/addStudent")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "pages/students/addStudent";
    }

    @GetMapping(value = "/listStudents")
    public String listStudent(Model model){
        model.addAttribute("students", StudentUtils.buildStudents());
        return "pages/students/listStudents";
    }

}
