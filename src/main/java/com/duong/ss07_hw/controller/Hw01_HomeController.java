package com.duong.ss07_hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hw01_HomeController {

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Spring MVC!");
        return "home"; // Tên file JSP là home.jsp
    }
}
