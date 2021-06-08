package com.persistDatabase;

import com.customer.Customer;
import com.database.HotelDatabase;
import com.database.PaymentTransactionDatabase;
import com.database.RegisteredUserDatabase;
import com.database.RoomsDatabase;
import com.hotel.Hotel;
import com.hotel.HotelInterface;
import com.paymentOptions.Payment;
import com.room.RoomInterface;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;

public class DeserializeDatabase {

    private Map<Integer , HotelInterface> hotelDatabase;
    private Map<Integer, RoomInterface> roomsDatabase;
    private  ArrayList<Customer> registeredUserDatabase;
    private Map<String  , Payment> paymentTransactionDatabase;

    public DeserializeDatabase() {
    }

    public void deserializeNow() {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/HotelDatabase.txt"));
            hotelDatabase = (Map<Integer, HotelInterface>) objectInputStream.readObject();
            objectInputStream = new ObjectInputStream(new FileInputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/RoomsDatabase.txt"));
            roomsDatabase = (Map<Integer, RoomInterface>) objectInputStream.readObject();
            objectInputStream = new ObjectInputStream(new FileInputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/RegisteredUserDatabase.txt"));
           registeredUserDatabase = (ArrayList<Customer>) objectInputStream.readObject();
            objectInputStream = new ObjectInputStream(new FileInputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/PaymentTransactionDatabase.txt"));
            paymentTransactionDatabase = (Map<String, Payment>) objectInputStream.readObject();



            //initialize the data in all database
            HotelDatabase.initiateDatabase(hotelDatabase);
            PaymentTransactionDatabase.initiateDatabase(paymentTransactionDatabase);
            RegisteredUserDatabase.initiateDatabase(registeredUserDatabase);
            RoomsDatabase.initiateDatabase(roomsDatabase);


        } catch(Exception e) {
            System.out.println("deserialization process doesnt take place successfully");
        }
    }

}
////