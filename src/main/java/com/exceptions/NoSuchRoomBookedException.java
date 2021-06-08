package com.exceptions;

public class NoSuchRoomBookedException extends Exception{
    public NoSuchRoomBookedException(String s) {
        super(s);
    }
}
