package com.duong.ss07_hw.controller;

import com.duong.ss07_hw.service.Hw10_CourseService;
import com.duong.ss07_hw.model.Hw10_Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class Hw10_CourseController {

    private final Hw10_CourseService courseService;

    public Hw10_CourseController(Hw10_CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "listCourse";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("course", new Hw10_Course());
        return "addCourse";
    }

    @PostMapping("/add")
    public String addCourse(@ModelAttribute("course") Hw10_Course course) {
        courseService.addCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return "redirect:/courses";
    }
}

