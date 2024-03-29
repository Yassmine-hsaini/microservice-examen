package com.ensa.student.controller;

import com.ensa.student.entities.Student;
import com.ensa.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save( @RequestBody Student student) {
        service.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(service.findAllStudents());
    }

    @GetMapping("/course/{course-id}")
    public ResponseEntity<List<Student>> findAllStudents(@PathVariable("course-id") Integer courseId) {
        return ResponseEntity.ok(service.findAllStudentsByCourse(courseId));
    }
}
