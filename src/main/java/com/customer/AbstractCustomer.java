package com.customer;

import java.io.Serializable;

public interface AbstractCustomer extends Serializable {

    public void setFullName(String fullName);
    public void setPhoneNumber(String phoneNumber);
    public void setEmailId(String emailId);
    public void setPassword(String password);
    public String getFullName();
    public String getPhoneNumber();
    public String getEmailId();
    public String getPassword();


}
