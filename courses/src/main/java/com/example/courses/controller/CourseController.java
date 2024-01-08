package com.example.courses.controller;


import com.example.courses.dto.CourseResponse;
import com.example.courses.entities.Course;
import com.example.courses.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Course course) {
        service.saveCourse(course);
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAllCourses() {
        return ResponseEntity.ok(service.findAllCourses());
    }

    @GetMapping("/with-students/{course-id}")
    public ResponseEntity<CourseResponse> findAllCourses(
            @PathVariable("course-id") Integer courseId
    ) {
        return ResponseEntity.ok(service.findCoursesWithStudents(courseId));
    }
}
