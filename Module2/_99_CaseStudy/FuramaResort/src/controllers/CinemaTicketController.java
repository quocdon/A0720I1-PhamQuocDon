package controllers;

import commons.InputData;
import models.Customer;

import static controllers.MainController.*;

public class CinemaTicketController {
    public static void cinemaTicket() {
        System.out.println("------------------");
        System.out.println("CINEMA TICKET MENU:\n" +
                "1. Buy ticket\n" +
                "2. Sell ticket\n" +
                "3. List of customer buying ticket\n" +
                "4. Stop selling ticket\n" +
                "5. Back to menu\n" +
                "6. Exit");
        System.out.print("Please choose function: ");
        String ticketIndex = scanner.nextLine();
        switch (ticketIndex) {
            case "1": {
                System.out.println("LIST OF CUSTOMERS");
                Customer customer = InputData.selectElementInList(customerList);
                waitingList.add(customer);
                System.out.println("add " + customer.showInfo() + "to waiting list successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                cinemaTicket();
                break;
            }
            case "2": {
                int soldTicket = 0;
                System.out.println("Number of customers in waiting list: " + waitingList.size());
                System.out.println("Number of tickets remaining: " + numTicket);
                System.out.print("Number of new tickets: ");
                numTicket += Integer.parseInt(scanner.nextLine());
                System.out.println("Total number of tickets: " + numTicket);
                while (numTicket > 0 && waitingList.size() > 0) {
                    boughtTicketList.add(waitingList.remove());
                    numTicket--;
                    soldTicket++;
                }
                System.out.println("Number of sold ticket: " + soldTicket);
                System.out.println("Number of tickets remaining: " + numTicket);
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                cinemaTicket();
                break;
            }
            case "3": {
                System.out.println("LIST OF CUSTOMER BUYING TICKET: ");
                for (Customer customer : boughtTicketList) {
                    System.out.println(customer.showInfo());
                }
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                cinemaTicket();
                break;
            }
            case "4": {
                //Stop selling ticket, clear all data in waitinglist, boughtTicketList and numberTicket remaining.
                boughtTicketList.clear();
                waitingList.clear();
                numTicket = 0;
                System.out.println("Stop selling ticket successfully");
                System.out.println("Press ENTER to continue");
                scanner.nextLine();
                cinemaTicket();
                break;
            }
            case "5": {
                displayMainMenu();
                break;
            }
            case "6": {
                System.exit(0);
            }
            default: {
                System.out.println("The index input is invalid. Please press ENTER to continue !!!");
                scanner.nextLine();
                cinemaTicket();
            }

        }
    }
}
