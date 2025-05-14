package com.duong.ss07_hw.repository;

import com.duong.ss07_hw.model.Hw10_Course;
import java.util.List;

public interface Hw10_CourseRepository {
    List<Hw10_Course> getAllCourses();
    void addCourse(Hw10_Course course);
    void deleteCourse(int id);
}
