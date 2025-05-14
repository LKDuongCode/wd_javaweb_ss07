package com.duong.ss07_hw.repository;

import com.duong.ss07_hw.model.Hw09_Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class Hw09_ProductRepositoryImpl implements Hw09_ProductRepository {

    private final List<Hw09_Product> products = new ArrayList<>();
    private int nextId = 1;

    @Override
    public List<Hw09_Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public Hw09_Product getProductById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void addProduct(Hw09_Product product) {
        product.setId(nextId++);
        products.add(product);
    }

    @Override
    public void updateProduct(Hw09_Product product) {
        deleteProduct(product.getId());
        products.add(product);
    }

    @Override
    public void deleteProduct(int id) {
        Iterator<Hw09_Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
}
