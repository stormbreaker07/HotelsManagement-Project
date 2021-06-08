package com.exceptions;

public class InvalidTransactionIdException extends Exception {
    public InvalidTransactionIdException(String s) {
        super(s);
    }
}
