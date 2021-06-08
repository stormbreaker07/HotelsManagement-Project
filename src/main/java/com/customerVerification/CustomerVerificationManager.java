package com.customerVerification;

import com.customer.AbstractCustomer;
import com.customer.Customer;
import com.exceptions.CustomerAlreadyRegisteredException;
import com.exceptions.CustomerNotRegisteredException;
import com.services.CheckValidCustomer;
import com.services.RegisterUser;

/**
 * works as management layer between userInterface and service class
 * main operations
 * Customer sign In
 * Customer sign Up
 */
public class CustomerVerificationManager {

    private AbstractCustomer customer;
    private CheckValidCustomer checkValidCustomer;
    private RegisterUser registerUser;

    /**
     * initialisze objects so that no need to initialize again and again
     */
    public CustomerVerificationManager() {

        customer = null;
        checkValidCustomer = new CheckValidCustomer();
        registerUser = new RegisterUser();

    }

    /**
     * sign up method register a user in the database if user already a registered then it get a exception message
     */
    public Boolean signUp(String name , String phoneNo , String emailId , String password) {

        try {
            Boolean result = registerUser.registerUser(name, phoneNo, emailId, password);
            if(result == true) {
                System.out.println("Customer registered successfully ");
                return true;
            }
            else {
                System.out.println("Customer signUp process failed tryAgain");
                return false;
            }
        }
        catch(CustomerAlreadyRegisteredException e) {
            System.out.println(e);
        }
        return false;
    }


    /**
     * check is Customer is a verified customer or registered customer. if not that get an exception message
     */
    public Boolean signIn(String emailId , String password) {

        try {
            Boolean result = checkValidCustomer.validCustomer(emailId, password);
            if(result == true) {
                System.out.println(" user signIn verification successful you may proceed now");
                return true;
            }
            else
            {
                System.out.println("non verified Customer");
                return false;
            }

        }
        catch(CustomerNotRegisteredException e) {
            System.out.println(e);
        }
        return false;
    }



}
