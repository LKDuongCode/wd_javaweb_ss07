package com.duong.ss07_hw.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hw05_AboutController {

    @GetMapping("/about")
    public String showAbout() {
        return "about";
    }
}
