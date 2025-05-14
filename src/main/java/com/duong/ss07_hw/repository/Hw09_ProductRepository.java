package com.duong.ss07_hw.repository;

import com.duong.ss07_hw.model.Hw09_Product;
import java.util.List;

public interface Hw09_ProductRepository {
    List<Hw09_Product> getAllProducts();
    Hw09_Product getProductById(int id);
    void addProduct(Hw09_Product product);
    void updateProduct(Hw09_Product product);
    void deleteProduct(int id);
}
