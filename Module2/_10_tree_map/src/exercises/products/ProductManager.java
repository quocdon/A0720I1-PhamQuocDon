package exercises.products;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> productList = new ArrayList<>();

    public static void mainMenu() {
        int menuIndex;
        do {
            System.out.print("-------------------------------------------------------\n" +
                    "MAIN MENU: \n" +
                    "1. Add new product\n" +
                    "2. Edit product by Id\n" +
                    "3. Delete product by Id\n" +
                    "4. Show product list\n" +
                    "5. Search product\n" +
                    "6. Sort product list ascending by price\n" +
                    "7. Sort product list descending by price\n" +
                    "8. Exit \n" +
                    "Please enter index of function: ");
            menuIndex = Integer.valueOf(scanner.nextLine());
        } while (menuIndex < 1 || menuIndex > 8);
        switch (menuIndex) {
            case 1: {
                addNewProduct();
                break;
            }
            case 2: {
                editProduct();
                break;
            }
            case 3: {
                removeProduct();
                break;
            }
            case 4: {
                showProductList();
                break;
            }
            case 5: {
                searchProduct();
                break;
            }
            case 6: {
                sortAscending();
                break;
            }
            case 7: {
                sortDescending();
                break;
            }
            case 8: {
                return;
            }
        }
    }

    public static void addNewProduct() {
        String id;
        String name;
        int price;
        System.out.println("INPUT INFORMATION OF PRODUCT:");
        do {
            System.out.print("1. ID: ");
            id = scanner.nextLine();
            if (Product.searchById(id, productList) != null) {
                System.out.println("The ID already exists, please input another ID");
            }
        } while (Product.searchById(id, productList) != null);

        System.out.print("2. Name: ");
        name = scanner.nextLine();
        System.out.print("3. Price: ");
        price = Integer.valueOf(scanner.nextLine());
        Product product = new Product(id, name, price);
        productList.add(product);
        System.out.println("** RESULT: Add " + product + " successfully **");
        mainMenu();
    }

    public static void editProduct() {
        System.out.print("Enter ID of product: ");
        String id = scanner.nextLine();
        Product product = Product.searchById(id, productList);
        if (product == null) {
            System.out.println("** RESULT: The product does not exist **");
        } else {
            int editIndex;
            do {
                System.out.print(product + "\n------------\n" +
                        "EDIT MENU:\n" +
                        "1. ID\n" +
                        "2. Name\n" +
                        "3. Price\n" +
                        "Please choose field edited: ");
                editIndex = Integer.valueOf(scanner.nextLine());
            } while (editIndex < 1 || editIndex > 3);
            switch (editIndex) {
                case 1: {
                    String newId;
                    do {
                        System.out.print("1. New ID: ");
                        newId = scanner.nextLine();
                        if (Product.searchById(newId, productList) != null) {
                            System.out.println("The ID already exists, please input another ID");
                        }
                    } while (Product.searchById(newId, productList) != null);
                    product.setId(newId);
                    break;
                }

                case 2: {
                    System.out.print("New name : ");
                    String name = scanner.nextLine();
                    product.setName(name);
                    break;
                }
                case 3: {
                    System.out.print("New price : ");
                    int price = Integer.valueOf(scanner.nextLine());
                    product.setPrice(price);
                    break;
                }
            }
            System.out.println("** RESULT: Edit " + product + " successfully **");
        }
        mainMenu();
    }

    public static void removeProduct() {
        System.out.print("Enter ID of product: ");
        String id = scanner.nextLine();
        Product product = Product.searchById(id, productList);
        if (product == null) {
            System.out.println("** RESULT: The product does not exist **");
        } else {
            productList.remove(product);
            System.out.println("** RESULT: Delete " + product + " successfully **");
        }
        mainMenu();
    }

    public static void showProductList() {
        System.out.println("LIST OF PRODUCTS:");
        for (Product product : productList) {
            System.out.println(product);
        }
        mainMenu();
    }

    public static void searchProduct() {
        System.out.print("Enter name of product: ");
        String name = scanner.nextLine();
        List<Product> result = Product.searchByName(name, productList);
        if (result.isEmpty()) {
            System.out.println("** RESULT: The product does not exist **");
        } else {
            System.out.println("** RESULT **");
            for (Product product : result) {
                System.out.println(product);
            }
        }
        mainMenu();
    }

    public static void sortAscending() {
        ProductSortAscending productSortAscending = new ProductSortAscending();
        Collections.sort(productList, productSortAscending);
        showProductList();
    }

    public static void sortDescending() {
        ProductSortDescending productSortDescending = new ProductSortDescending();
        Collections.sort(productList, productSortDescending);
        showProductList();
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
