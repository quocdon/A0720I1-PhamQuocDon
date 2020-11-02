package exercises.products;

import java.util.Comparator;

public class ProductSortDescending implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return product2.getPrice() - product1.getPrice();
    }
}
