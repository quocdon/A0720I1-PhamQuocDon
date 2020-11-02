package exercises.products;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String id;
    private String name;
    private int price;

    public Product() {

    }

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static Product searchById(String id, List<Product> productList) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public static List<Product> searchByName(String name, List<Product> productList) {
        List<Product> list = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                list.add(product);
            }
        }
        return list;
    }
}
