package Controllers;

import Commons.FileUtils;
import Models.Deposit;
import Models.LongTermDeposit;
import Models.MonthsTermDeposit;
import Models.NonTermDeposit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Controllers.MainControllers.*;

public class AddNewDeposit {
    public static Scanner scanner = new Scanner(System.in);
    public static void addNewDeposit(){
        System.out.println("THEM MOI SO TIET KIEM\n" +
                "1. So tiet kiem dai han\n" +
                "2. So tiet kiem ngan han\n" +
                "Vui long chon: ");
        String index = scanner.nextLine();
        switch (index){
            case "1": {
                List<String> data = new ArrayList<>();
                data = NewDeposit.inputData("longTerm");
                LongTermDeposit deposit = new LongTermDeposit(data.get(0), data.get(1), data.get(2), data.get(3),
                        data.get(4), data.get(5), data.get(6), data.get(7));
                longTermDepositList.add(deposit);
                FileUtils.writeDepositToCSV(longTermDepositList, "src/Data/longTerm.csv");
                System.out.println("Them so tiet kiem thanh cong");
                mainMenu();
                break;
            }
            case "2": {
                System.out.println("1. So tiet kiem vo thoi han\n" +
                        "2. So tiet kiem ngan han");
                String subIndex = scanner.nextLine();
                switch (subIndex){
                    case "1":{
                        List<String> data = new ArrayList<>();
                        data = NewDeposit.inputData("nonTerm");
                        NonTermDeposit deposit = new NonTermDeposit(data.get(0), data.get(1), data.get(2), data.get(3),
                                data.get(4), data.get(5));
                        shortTermDepositList.add(deposit);
                        FileUtils.writeDepositToCSV(shortTermDepositList, "src/Data/shortTerm.csv");
                        System.out.println("Them so tiet kiem thanh cong");
                        mainMenu();
                        break;
                    }
                    case "2":{
                        List<String> data = new ArrayList<>();
                        data = NewDeposit.inputData("nonTerm");
                        MonthsTermDeposit deposit = new MonthsTermDeposit(data.get(0), data.get(1), data.get(2), data.get(3),
                                data.get(4), data.get(5), data.get(6));
                        shortTermDepositList.add(deposit);
                        FileUtils.writeDepositToCSV(shortTermDepositList, "src/Data/shortTerm.csv");
                        System.out.println("Them so tiet kiem thanh cong");
                        mainMenu();
                        break;
                    }
                    default:
                        System.out.println("Vui long chon lai");
                        addNewDeposit();
                }

            }
            case "3": {


                break;
            }
            case "4": {
                break;
            }
            default:
                mainMenu();
        }
    }
}
