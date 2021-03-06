package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Iphone 5", 300, "Apple"));
        products.put(2, new Product(2, "Iphone 6", 400, "Apple"));
        products.put(3, new Product(3, "Iphone 7", 500, "Apple"));
        products.put(4, new Product(4, "Iphone 8", 700, "Apple"));
        products.put(5, new Product(5, "Iphone X", 1000, "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public int generateNewId() {
        List<Product> products = this.findAll();
        int lastId = 0;
        if (products.size() == 0) {
            return 1;
        } else {
            for (Product product : products) {
                if (lastId < product.getId()) {
                    lastId = product.getId();
                }
            }
        }
        return lastId + 1;
    }
}
