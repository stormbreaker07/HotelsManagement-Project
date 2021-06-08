package com.customer;

import java.io.Serializable;

/**
 * Customer class , use to create customer objects.
 * used to user data as a object in database.
 * for verification process.
 */
public class Customer implements AbstractCustomer{

    private String fullName;
    private String password;
    private String emailId;
    private String phoneNumber;

    public Customer(String fullName , String phoneNumber , String emailId , String password)
    {
        setFullName(fullName);
        setPhoneNumber(phoneNumber);
        setEmailId(emailId);
        setPassword(password);
    }


    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String getEmailId() {
        return this.emailId;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
