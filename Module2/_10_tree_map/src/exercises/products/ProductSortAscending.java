package exercises.products;

import java.util.Comparator;

public class ProductSortAscending implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return product1.getPrice() - product2.getPrice();
    }
}
