package Controllers;

import Models.LongTermDeposit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Controllers.MainControllers.*;

public class NewDeposit {
    public static Scanner scanner = new Scanner(System.in);
    public static List<String> inputData(String deposit){
        List<String> data = new ArrayList<>();
        String temp = "";
        do{
            System.out.println("Ma so so: ");
            temp = scanner.nextLine();
        } while (!DataValidate.checkDepositId(temp) || !DataValidate.checkDuplicate(temp, longTermDepositList));
        data.add(temp);
        do {
            System.out.println("Ma khach hang");
            temp = scanner.nextLine();
        } while (!DataValidate.checkCustomerId(temp, customerList));
        data.add(temp);
        do {
            System.out.println("Ngay mo so:");
            temp = scanner.nextLine();
        } while (!DataValidate.checkDate(temp));
        data.add(temp);
        do {
            System.out.println("Thoi gian bat dau gui: ");
            temp = scanner.nextLine();
        } while (!DataValidate.checkDate(temp));
        data.add(temp);
        do {
            System.out.println("So tien gui");
            temp = scanner.nextLine();
        } while (!DataValidate.checkAmount(temp));
        data.add(temp);
        System.out.println("Lai suat:");
        temp = scanner.nextLine();
        data.add(temp);
        if (deposit.equals("longTerm") || deposit.equals("shortTerm")){
            System.out.println("Ky han:");
            temp = scanner.nextLine();
        }
        data.add(temp);
        if (deposit.equals("longTerm")){
            System.out.println("Uu dai");
            temp = scanner.nextLine();
            data.add(temp);
        }
        return data;
    }


}
