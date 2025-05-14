package com.duong.ss07_hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hw05_ContactController {

    @GetMapping("/contact")
    public String showContact() {
        return "contact";
    }
}
