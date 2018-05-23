package com.filip.springbootjava8and10.repositories;

import com.filip.springbootjava8and10.domain.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
