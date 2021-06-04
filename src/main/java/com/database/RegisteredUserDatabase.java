package com.database;


import com.customer.Customer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * singleton class
 * it stores the data of registered user for login verification
 * two main operation are register a user.
 * check if user exist in the database
 */
public class RegisteredUserDatabase implements Serializable {

    private static ArrayList<Customer> data = null;
    private static RegisteredUserDatabase instance = null;

    private RegisteredUserDatabase() {
        initialization();
    }

    public static RegisteredUserDatabase getInstance() {
        if(instance == null) {
            instance = new RegisteredUserDatabase();
        }
        return instance;
    }


    public static void initialization( ) {
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
