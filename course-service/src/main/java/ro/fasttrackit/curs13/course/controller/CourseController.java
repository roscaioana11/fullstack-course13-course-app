package ro.fasttrackit.curs13.course.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs13.course.dto.Course;
import ro.fasttrackit.curs13.course.dto.CourseStudent;
import ro.fasttrackit.curs13.course.model.mappers.CourseMappers;
import ro.fasttrackit.curs13.course.model.mappers.CourseStudentMappers;
import ro.fasttrackit.curs13.course.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService service;
    private final CourseMappers mapper;
    private final CourseStudentMappers courseStudentMappers;

    @GetMapping
    List<Course> getAll() {
        return mapper.toApi(service.getAll());
    }

    @PostMapping("{courseId}/students/{studentId}")
    CourseStudent addStudentToCourse(@PathVariable long courseId, @PathVariable String studentId) {
        return courseStudentMappers.toApi(service.addStudentToCourse(courseId, studentId));
    }
}
