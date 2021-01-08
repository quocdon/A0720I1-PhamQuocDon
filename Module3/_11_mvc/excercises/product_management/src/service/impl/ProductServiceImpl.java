package service.impl;

import model.Product;
import service.ProductService;

import java.util.*;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products = new HashMap<>();
    private static int lastId = 0;

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        lastId++;
        product.setId(lastId);
        products.put(product.getId(), product);
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
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        Set<Integer> keySet = products.keySet();
        for (int key : keySet) {
            if (products.get(key).getName().equals(name)) {
                result.add(products.get(key));
            }
        }
        return result;
    }
}
