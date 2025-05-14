package com.duong.ss07_hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hw03_ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        return "error";
    }
}
