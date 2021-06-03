package com.database;


import com.customer.Customer;

import java.util.ArrayList;

/**
 * singleton class
 * it stores the data of registered user for login verification
 * two main operation are register a user.
 * check if user exist in the database
 */
public class RegisteredUserDatabase {

    private RegisteredUserDatabase() {}

    private static ArrayList<Customer> data = null;

    public void initialization( ) {
        if(data == null) {
            data = new ArrayList<>();
        }
    }

    /**
     * add customer pbject in the database
     * @param customer
     */
    public static void addCustomer(Customer customer) {

        data.add(customer);
    }

    /**
     * find if the customer is present in database or not
     * @param emailId
     * @param password
     * @return
     */
    public static Customer findCustomer(String emailId , String password) {

        for(Customer temp : data) {
            if(temp.getEmailId().equals(emailId)  && temp.getPassword().equals(password)) {
               return temp;
            }
        }
        return null;
    }

}
