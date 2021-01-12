package services;

import models.Customer;

import java.util.*;

public class CustomerService {
    public static Map<String, Customer> customerMap = new HashMap<>();

    public Map<String, Customer> getCustomerMap() {
        return customerMap;
    }

    public List<Customer> getCustomerList(){
        Set<String> keySet = customerMap.keySet();
        List<Customer> customerList = new ArrayList<>();
        for (String key : keySet){
            customerList.add(customerMap.get(key));
        }
        return customerList;
    }

    public void addCustomer(Customer customer) {
        customerMap.put(customer.getUsername(), customer);
    }


    public boolean checkLogin(String username, String password){
        try{
            if (customerMap.get(username).getPassword().equals(password)){
                return true;
            }
        }catch (Exception e){
            return false;
        }

        return false;
    }

    public boolean checkRegister(String username){
        try{
            if (customerMap.get(username) == null){
                return true;
            }
        } catch (Exception e){
            return true;
        }
        return false;
    }
}
