package com.ensa.student.repository;

import com.ensa.student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByCourseId(Integer courseId);
}
