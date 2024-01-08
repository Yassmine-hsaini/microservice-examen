package com.example.courses.service;


import com.example.courses.client.StudentClient;
import com.example.courses.dto.CourseResponse;
import com.example.courses.entities.Course;
import com.example.courses.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepo repository;
    private final StudentClient client;

    public void saveCourse(Course course) {
        repository.save(course);
    }

    public List<Course> findAllCourses() {
        return repository.findAll();
    }

    public CourseResponse findCoursesWithStudents(Integer courseId) {
        var course = repository.findById(courseId)
                .orElseGet(() ->
                        Course.builder()
                                .name("NOT_FOUND")
                                .desc("NOT_FOUND")
                                .build()
                );
        var students = client.findAllStudentsByCourse(courseId);
        return CourseResponse.builder()
                .name(course.getName())
                .desc(course.getDesc())
                .students(students)
                .build();
    }
}

