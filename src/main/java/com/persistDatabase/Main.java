package com.persistDatabase;

import com.customer.Customer;
import com.database.HotelDatabase;
import com.database.RegisteredUserDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HotelDatabase.initiateDatabase();
        HotelDatabase.deleteWholeDatbase();
        DeserializeDatabase deserializeDatabase = new DeserializeDatabase();
        deserializeDatabase.deserializeNow();
        ArrayList<Customer> data = RegisteredUserDatabase.wholeData();
        for(Customer x : data) {
            System.out.println(x.getEmailId() + "   "  + x.getPassword());
        }
    }
}
