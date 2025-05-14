package com.duong.ss07_hw.repository;

import com.duong.ss07_hw.model.Hw10_Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class Hw10_CourseRepositoryImpl implements Hw10_CourseRepository {

    private final List<Hw10_Course> courses = new ArrayList<>();
    private int nextId = 1;

    @Override
    public List<Hw10_Course> getAllCourses() {
        return new ArrayList<>(courses);
    }

    @Override
    public void addCourse(Hw10_Course course) {
        course.setId(nextId++);
        courses.add(course);
    }

    @Override
    public void deleteCourse(int id) {
        Iterator<Hw10_Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
}
