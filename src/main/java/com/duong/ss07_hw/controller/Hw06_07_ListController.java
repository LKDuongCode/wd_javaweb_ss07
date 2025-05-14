package com.duong.ss07_hw.controller;

import com.duong.ss07_hw.model.Hw06_07_CartItem;
import com.duong.ss07_hw.model.Hw06_07_Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/list")
public class Hw06_07_ListController {
    private final List<Hw06_07_CartItem> cartItems = new ArrayList<>();

    private List<Hw06_07_Product> getProductList() {
        List<Hw06_07_Product> products = new ArrayList<>();

        products.add(new Hw06_07_Product() {{
            setId(1L);
            setName("iPhone 15 Pro Max");
            setPrice(1299.99);
            setStock(10);
            setDescription("iPhone mới nhất, camera siêu nét, chip A17 Pro mạnh mẽ.");
            setImage("https://example.com/iphone15.jpg");
        }});

        products.add(new Hw06_07_Product() {{
            setId(2L);
            setName("MacBook Air M3");
            setPrice(1499.99);
            setStock(5);
            setDescription("MacBook Air mỏng nhẹ, chip M3 siêu mạnh.");
            setImage("https://example.com/macbookair.jpg");
        }});

        products.add(new Hw06_07_Product() {{
            setId(3L);
            setName("Samsung Galaxy S24 Ultra");
            setPrice(1199.99);
            setStock(8);
            setDescription("Galaxy S24 Ultra với zoom siêu khủng, hiệu năng đỉnh.");
            setImage("https://example.com/galaxyS24.jpg");
        }});

        return products;
    }

    @GetMapping
    public String showProductList(Model model) {
        model.addAttribute("products", getProductList());
        return "product_list";
    }

    @GetMapping("/details")
    public String showProductDetails(@RequestParam Long id, Model model) {
        Hw06_07_Product foundProduct = getProductList().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (foundProduct == null) {
            return "redirect:/list";
        }

        model.addAttribute("product", foundProduct);
        return "product_details";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam Long id, @RequestParam int quantity, Model model) {
        if (quantity <= 0) {
            model.addAttribute("error", "Số lượng phải lớn hơn 0.");
            model.addAttribute("products", getProductList());
            return "product_list";
        }

        Hw06_07_Product product = getProductList().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (product == null) {
            return "redirect:/list";
        }

        Hw06_07_CartItem existingItem = cartItems.stream()
                .filter(item -> item.getProduct().getId().equals(id))
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            Hw06_07_CartItem newItem = new Hw06_07_CartItem();
            newItem.setProduct(product);
            newItem.setQuantity(quantity);
            cartItems.add(newItem);
        }

        return "redirect:/list";
    }


    @GetMapping("/cart")
    public String showCart(Model model) {
        double total = cartItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", total);

        return "cart";
    }


    @GetMapping("/cart/increase")
    public String increaseQuantity(@RequestParam Long id) {
        cartItems.stream()
                .filter(item -> item.getProduct().getId().equals(id))
                .findFirst()
                .ifPresent(item -> item.setQuantity(item.getQuantity() + 1));
        return "redirect:/list/cart";
    }

    @GetMapping("/cart/decrease")
    public String decreaseQuantity(@RequestParam Long id) {
        cartItems.stream()
                .filter(item -> item.getProduct().getId().equals(id))
                .findFirst()
                .ifPresent(item -> {
                    if (item.getQuantity() > 1) {
                        item.setQuantity(item.getQuantity() - 1);
                    }
                });
        return "redirect:/list/cart";
    }

    @GetMapping("/cart/remove")
    public String removeFromCart(@RequestParam Long id) {
        cartItems.removeIf(item -> item.getProduct().getId().equals(id));
        return "redirect:/list/cart";
    }



}
