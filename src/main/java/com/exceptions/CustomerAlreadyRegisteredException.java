package com.exceptions;

public class CustomerAlreadyRegisteredException extends Exception{
    public CustomerAlreadyRegisteredException(String s) {
        super(s);
    }
}
