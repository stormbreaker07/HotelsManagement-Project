package com.services;

import com.customer.Customer;
import com.database.RegisteredUserDatabase;
import com.exceptions.CustomerAlreadyRegisteredException;
import com.exceptions.CustomerNotRegisteredException;

/**
 * service use to check is a user is a valid user means if its data exist in database or it is a registered user
 *or not
 */
public class CheckValidCustomer {

    private Customer customer;

    public CheckValidCustomer() { customer = null;}

    public Boolean validCustomer(String emailId , String password) throws CustomerNotRegisteredException {

        customer = RegisteredUserDatabase.findCustomer(emailId , password);
        if(customer != null) {
           return true;
        }
        else {
            throw new CustomerNotRegisteredException("Customer with " + emailId + "is not a registerd customer in the app");
        }

    }
}
