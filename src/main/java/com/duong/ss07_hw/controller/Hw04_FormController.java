package com.duong.ss07_hw.controller;

import com.duong.ss07_hw.model.Hw04_Feedback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/feedback")
public class Hw04_FormController {

    private final List<Hw04_Feedback> feedbackList = new ArrayList<>();

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("feedback", new Hw04_Feedback());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("feedback") Hw04_Feedback feedback, Model model) {
        // Validate fullName
        if (feedback.getFullName() == null || feedback.getFullName().trim().isEmpty()) {
            model.addAttribute("error", "Họ và tên là bắt buộc.");
            return "form";
        }

        // Validate content
        if (feedback.getContent() == null || feedback.getContent().trim().isEmpty()) {
            model.addAttribute("error", "Nội dung góp ý là bắt buộc.");
            return "form";
        }

        // Validate phone
        String phonePattern = "\\d{9,11}";
        if (feedback.getPhone() != null && !feedback.getPhone().matches(phonePattern)) {
            model.addAttribute("error", "Số điện thoại không hợp lệ. Chỉ chứa số và dài 9-11 chữ số.");
            return "form";
        }

        // Add to list
        feedbackList.add(feedback);
        model.addAttribute("feedback", feedback);

        return "result";
    }

    @GetMapping("/list")
    public String showFeedbackList(Model model) {
        model.addAttribute("feedbackList", feedbackList);
        return "list";
    }
}

