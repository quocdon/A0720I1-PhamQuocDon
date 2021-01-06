package services;

import models.Customer;

import java.util.*;

public class CustomerService {
    public static Map<String, Customer> customerMap = new HashMap<>();

    public Map<String, Customer> getCustomerMap() {
        return customerMap;
    }

    public List<Customer> getCustomerList() {
        List<Customer> customerList = new ArrayList<>();
        Set<String> keySet = customerMap.keySet();
        for (String key : keySet){
            customerList.add(customerMap.get(key));
        }
        return customerList;
    }

    public void addCustomer(Customer customer) {
        customerMap.put(customer.getUsername(), customer);
    }


    public boolean checkLogin(String username, String password) {
        try {
            return (customerMap.get(username).getPassword().equals(password));
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean checkRegister(String username) {
        return !customerMap.containsKey(username);
    }
}
