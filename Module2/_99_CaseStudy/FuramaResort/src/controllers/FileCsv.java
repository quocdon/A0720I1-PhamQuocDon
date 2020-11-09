package controllers;

import javafx.scene.control.skin.CellSkinBase;
import models.House;
import models.Room;
import models.Services;
import models.Villa;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileCsv {
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void writeServicesToCSV(List<Services> serviceList, String url) {

        //Method writing service list to the file following the url.

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(url);
            for (Services service : serviceList) {
                //Writing header of the file
                if (serviceList.indexOf(service) == 0) {
                    fileWriter.append(service.getHeader());
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
                fileWriter.append(service.toString());
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

    public static List<Services> getServiceListFromCSV(String url) {
        //Method reading list of services from the file following the url.

        BufferedReader br = null;
        List<Services> serviceList = new ArrayList<>();
        Path path = Paths.get(url);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(url);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            String line;
            String serviceId = null;
            br = new BufferedReader(new FileReader(url));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[1].equals("Service Name")) {
                    //Skip reading header
                    //Identify class of elements of the list through first column of header.
                    serviceId = splitData[0];
                    continue;
                }

                //Base on service ID to identify class of elements, initialize service object and add to the list
                if (serviceId.equals("Villa Id")) {
                    Villa villa = new Villa(splitData[0], splitData[1], Double.valueOf(splitData[2]), Double.valueOf(splitData[3]),
                            Integer.valueOf(splitData[4]), splitData[5], splitData[6], splitData[7], Double.valueOf(splitData[8]), Integer.valueOf(splitData[9]));
                    serviceList.add(villa);
                } else if (serviceId.equals("House Id")) {
                    House house = new House(splitData[0], splitData[1], Double.valueOf(splitData[2]), Double.valueOf(splitData[3]),
                            Integer.valueOf(splitData[4]), splitData[5], splitData[6], splitData[7], Integer.valueOf(splitData[8]));
                    serviceList.add(house);
                } else if (serviceId.equals("Room Id")) {
                    Room room = new Room(splitData[0], splitData[1], Double.valueOf(splitData[2]), Double.valueOf(splitData[3]),
                            Integer.valueOf(splitData[4]), splitData[5], splitData[6]);
                    serviceList.add(room);
                }
            }
            return serviceList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return serviceList;
    }
}
