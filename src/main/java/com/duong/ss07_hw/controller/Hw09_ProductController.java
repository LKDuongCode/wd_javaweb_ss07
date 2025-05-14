package com.duong.ss07_hw.controller;

import com.duong.ss07_hw.model.Hw09_Category;
import com.duong.ss07_hw.model.Hw09_Product;
import com.duong.ss07_hw.repository.Hw09_ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
public class Hw09_ProductController {

    private final Hw09_ProductRepository productRepository;

    public Hw09_ProductController(Hw09_ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @ModelAttribute("categories")
    public List<Hw09_Category> populateCategories() {
        List<Hw09_Category> categories = new ArrayList<>();
        categories.add(new Hw09_Category() {{ setId(1); setName("Electronics"); }});
        categories.add(new Hw09_Category() {{ setId(2); setName("Books"); }});
        categories.add(new Hw09_Category() {{ setId(3); setName("Clothes"); }});
        return categories;
    }

    @GetMapping
    public String listProducts(@RequestParam(defaultValue = "") String keyword,
                               @RequestParam(defaultValue = "1") int page,
                               Model model) {
        List<Hw09_Product> allProducts = productRepository.getAllProducts();
        List<Hw09_Product> filtered = allProducts.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        int pageSize = 5;
        int totalPage = (int) Math.ceil((double) filtered.size() / pageSize);
        int start = (page - 1) * pageSize;
        int end = Math.min(start + pageSize, filtered.size());

        model.addAttribute("products", filtered.subList(start, end));
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", totalPage);

        return "productList";
    }

    @GetMapping("/{id}")
    public String showProductDetails(@PathVariable int id, Model model) {
        Hw09_Product product = productRepository.getProductById(id);
        if (product == null) return "redirect:/products";

        model.addAttribute("product", product);
        return "productDetails";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Hw09_Product());
        return "addProduct";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Hw09_Product product, RedirectAttributes redirectAttributes) {
        productRepository.addProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product added successfully!");
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable int id, Model model) {
        Hw09_Product product = productRepository.getProductById(id);
        if (product == null) return "redirect:/products";

        model.addAttribute("product", product);
        return "editProduct";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Hw09_Product product, RedirectAttributes redirectAttributes) {
        productRepository.updateProduct(product);
        redirectAttributes.addFlashAttribute("message", "Product updated successfully!");
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, RedirectAttributes redirectAttributes) {
        productRepository.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message", "Product deleted successfully!");
        return "redirect:/products";
    }
}
