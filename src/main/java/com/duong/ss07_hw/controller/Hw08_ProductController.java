package com.duong.ss07_hw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/products")
public class Hw08_ProductController {

    @RequestMapping("/{category}")
    public String getProductsByCategory(@PathVariable String category,
                                        @MatrixVariable(pathVar = "category", value = "color", required = false) String color,
                                        @MatrixVariable(pathVar = "category", value = "size", required = false) String size,
                                        Model model) {

        model.addAttribute("category", category);
        model.addAttribute("color", color != null ? color : "all");
        model.addAttribute("size", size != null ? size : "all");


        return "productMatrixView";
    }

    @RequestMapping("/filter/{type}")
    public String filterProducts(@PathVariable String type,
                                 @MatrixVariable(pathVar = "type") Map<String, String> matrixVars,
                                 Model model) {

        model.addAttribute("type", type);
        model.addAttribute("filters", matrixVars);

        return "productMatrixFilterView";
    }
}
