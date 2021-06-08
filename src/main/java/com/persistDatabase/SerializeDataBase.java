package com.persistDatabase;

import com.database.HotelDatabase;
import com.database.PaymentTransactionDatabase;
import com.database.RegisteredUserDatabase;
import com.database.RoomsDatabase;
import com.exceptions.HotelAlreadyRegisteredException;
import com.hotel.Hotel;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeDataBase {



    public SerializeDataBase() {

        RoomsDatabase.initiate();
        PaymentTransactionDatabase.initialize();
        HotelDatabase.initiateDatabase();
        RegisteredUserDatabase.initialization();


        try {
            FileOutputStream write = new FileOutputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/HotelDatabase.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(write);
            objectOutputStream.writeObject(HotelDatabase.wholeData());
            objectOutputStream.flush();
            objectOutputStream.close();

            write = new FileOutputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/RoomsDatabase.txt");
            objectOutputStream = new ObjectOutputStream(write);
            objectOutputStream.writeObject(RoomsDatabase.wholeData());
            objectOutputStream.flush();
            objectOutputStream.close();

            write = new FileOutputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/RegisteredUserDatabase.txt");
            objectOutputStream = new ObjectOutputStream(write);
            objectOutputStream.writeObject(RegisteredUserDatabase.wholeData());
            objectOutputStream.flush();
            objectOutputStream.close();

            write = new FileOutputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/PaymentTransactionDatabase.txt");
            objectOutputStream = new ObjectOutputStream(write);
            objectOutputStream.writeObject(PaymentTransactionDatabase.allTransaction());
            objectOutputStream.flush();
            objectOutputStream.close();

        } catch (Exception e) {
            System.out.println("serialization process doesnt take place successfully");
            e.printStackTrace();
        }


    }
}

