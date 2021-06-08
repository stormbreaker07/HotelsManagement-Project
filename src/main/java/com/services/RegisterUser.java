package com.services;

import com.customer.Customer;
import com.database.RegisteredUserDatabase;
import com.exceptions.CustomerAlreadyRegisteredException;

/**
 * registerUser service use to register the user by checking if there is some other user exist in database with same
 * credential if not then register the user
 */
public class RegisterUser {

    private Customer customer;

    public RegisterUser() {
        customer = null;
    }

    public Boolean registerUser(String name , String phoneNumber , String email , String password) throws CustomerAlreadyRegisteredException {

        customer = RegisteredUserDatabase.findCustomer(email , password);
        if(customer == null) {
            customer = new Customer(name , phoneNumber , email ,  password);
            RegisteredUserDatabase.addCustomer(customer);
            return true;
        }
        else {
            throw new CustomerAlreadyRegisteredException("Customer with " + email + " is already a registerd customer");
        }
    }
}
