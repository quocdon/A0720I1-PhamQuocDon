package commons;

import models.Customer;

import java.util.Comparator;

public class SortCustomerByNameBirthday implements Comparator<Customer> {
    @Override
    public int compare(Customer customer1, Customer customer2) {
        int result = customer1.getFirstName().compareTo(customer2.getFirstName());
        if (result == 0){
            return customer1.getBirthdayToDate().compareTo(customer2.getBirthdayToDate());
        }
        return result;
    }
}
