package Controllers;

import Commons.FileUtils;
import Models.Customer;
import Models.Deposit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainControllers {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Customer> customerList = new ArrayList<>();
    public static List<Deposit> depositList = new ArrayList<>();
    public static List<Deposit> longTermDepositList = new ArrayList<>();
    public static List<Deposit> shortTermDepositList = new ArrayList<>();

    public static void mainMenu(){
        System.out.println("CHUONG TRINH QUAN LY TIET KIEM\n" +
                "1. Them moi so tiet kiem\n" +
                "2. Xoa so tiet kiem\n" +
                "3. Xem danh sach so tiet kiem\n" +
                "4. Xem thong tin khach hang\n" +
                "5. Tim kiem so tiet kiem\n" +
                "6. Thoat\n" +
                "Chon chuc nang: ");
        String index = scanner.nextLine();
        switch (index){
            case "1":{
                AddNewDeposit.addNewDeposit();
                break;
            }
            case "2":{
                break;

            }
            case "3":{
                System.out.println("HIEN THI DANH SACH" +
                        "1. So tiet kiem dai han\n" +
                        "2. So tiet kiem ngan han" +

                        "Vui long chon: ");
                String subIndex = scanner.nextLine();
                switch (subIndex) {
                    case "1": {
                        for (Deposit deposit : longTermDepositList) {
                            System.out.println(deposit.showInfo());
                        }
                        break;
                    }
                    case "2": {
                        for (Deposit deposit : shortTermDepositList) {
                            System.out.println(deposit.showInfo());
                        }
                        break;
                    }
                    default:
                        mainMenu();
                }
                break;

            }
            case "4":{
                mainMenu();
                break;
            }
            case "5":{
                mainMenu();
                break;
            }
            case "6":{
                System.exit(0);
            }
            default:{
                mainMenu();
            }
        }
    }

    public static void main(String[] args) {
        customerList = FileUtils.readCustomerListFromCSV("src/Data/Customer.csv");
        mainMenu();
    }
}
