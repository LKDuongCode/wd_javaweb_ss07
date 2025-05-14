package com.duong.ss07_hw.service;


import com.duong.ss07_hw.model.Hw10_Course;
import com.duong.ss07_hw.repository.Hw10_CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Hw10_CourseServiceImpl implements Hw10_CourseService {

    private final Hw10_CourseRepository courseRepository;

    public Hw10_CourseServiceImpl(Hw10_CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Hw10_Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public void addCourse(Hw10_Course course) {
        courseRepository.addCourse(course);
    }

    @Override
    public void deleteCourse(int id) {
        courseRepository.deleteCourse(id);
    }
}
