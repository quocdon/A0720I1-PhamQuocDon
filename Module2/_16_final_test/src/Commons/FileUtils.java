package Commons;

import Models.Customer;
import Models.Deposit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String HEADER = "Ma so so,Ma khach hang,Ngay mo so,Thoi gian bat dau gui,So tien gui,Lai suat,Ky han (neu co),uu dai(neu co)";

    public static void writeDepositToCSV(List<Deposit> depositList, String filePath) {
        //**Method writing service list to the file following the file path.
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            for (Deposit deposit : depositList) {
                //Writing header to the file
                if (depositList.indexOf(deposit) == 0) {
                    fileWriter.append(HEADER);
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
                //Writing service data to the file
                fileWriter.append(deposit.toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Customer> readCustomerListFromCSV(String filePath) {

        BufferedReader br = null;
        List<Customer> customerList = new ArrayList<>();

        //Check the file exists or not. If not, create new file following the file path
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(filePath);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //Reading data from the file
        try {
            String line;
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                Customer customer = new Customer(splitData[0], splitData[1], splitData[2], splitData[3], splitData[4], splitData[5]);
                customerList.add(customer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return customerList;
    }
}