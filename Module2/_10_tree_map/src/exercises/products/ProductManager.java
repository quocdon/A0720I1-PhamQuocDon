package exercises.products;

import practices.comparable_comparator.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> productList = new ArrayList<>();

    public static void mainMenu() {
        int menuIndex;
        do {
            System.out.println("MAIN MENU: \n" +
                    "1. Add new product\n" +
                    "2. Edit product by Id\n" +
                    "3. Delete product by Id\n" +
                    "4. Show product list\n" +
                    "5. Search product\n" +
                    "6. Sort product list ascending by price\n" +
                    "7. Sort product list descending by price\n" +
                    "8. Exit \n"+
                    "Please enter index of function: ");
            menuIndex = Integer.valueOf(scanner.nextLine());
        } while (menuIndex < 1 || menuIndex > 7);
        switch (menuIndex){
            case 1:{
                addNewProduct();
                break;
            }
            case 4:{
                showProductList();
                break;
            }
        }
    }

    public static void showProductList(){
        for (Product product: productList){
            System.out.println(product);
        }
        mainMenu();
    }

    public static void addNewProduct() {
        int id = productList.size() + 1;
        String name;
        int price;
        System.out.println("ENTER INFORMATION OF PRODUCT:");
        System.out.println("1. ID: " + id);
        System.out.print("2. Name: ");
        name = scanner.nextLine();
        System.out.print("3. Price: ");
        price = Integer.valueOf(scanner.nextLine());
        Product product = new Product(id, name, price);
        productList.add(product);
        System.out.println("Add product " + product.toString() + " successful\n----------------\n");
        mainMenu();
    }


    public static void main(String[] args) {
        mainMenu();

    }
}
