package com.filip.springbootjava8and10.services.jpa;

import com.filip.springbootjava8and10.domain.models.Student;
import com.filip.springbootjava8and10.exceptions.StudentNotFoundException;
import com.filip.springbootjava8and10.repositories.StudentRepository;
import com.filip.springbootjava8and10.web.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream()
                .map(student -> new StudentDTO(student.getId(), student.getName(), student.getGender(), student.getPercentage()))
                .collect(Collectors.toList());
    }

    @Transactional
    public StudentDTO create(StudentDTO student) {
        Student newStudent = new Student();
        newStudent.setGender(student.getGender());
        newStudent.setName(student.getName());
        newStudent.setPercentage(student.getPercentage());
        Student savedStudent = studentRepository.saveAndFlush(newStudent);
        return new StudentDTO(savedStudent.getId(), savedStudent.getName(), savedStudent.getGender(), savedStudent.getPercentage());
    }

    @Transactional
    public StudentDTO update(Long id, StudentDTO student) {
        Student entity = findOneSafe(id);
        entity.setName(student.getName());
        entity.setPercentage(student.getPercentage());
        entity.setGender(student.getGender());
        return new StudentDTO(entity.getId(), entity.getName(), entity.getGender(), entity.getPercentage());
    }

    @Transactional
    public void delete(Long id){
        Student student = findOneSafe(id);
        studentRepository.delete(student);
    }

    private Student findOneSafe(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            throw new StudentNotFoundException(id);
        } else {
            return student;
        }
    }
}
