package com.userInterface;

import com.database.HotelDatabase;
import com.database.PaymentTransactionDatabase;
import com.database.RegisteredUserDatabase;
import com.database.RoomsDatabase;
import com.persistDatabase.SerializeDataBase;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HotelDatabase hotelDatabase = HotelDatabase.getInstance();
        PaymentTransactionDatabase paymentTransactionDatabase = PaymentTransactionDatabase.getInstance();
        RegisteredUserDatabase registeredUserDatabase = RegisteredUserDatabase.getInstance();
        RoomsDatabase roomsDatabase = RoomsDatabase.getInstance();

        SerializeDataBase serializeDataBase = new SerializeDataBase();


//        PaymentTransactionDatabase.initialize();
//        Scanner scan = new Scanner(System.in);
//        String amount = scan.nextLine();
//
//        PaymentUI paymentUI = new PaymentUI(scan , amount);
//        paymentUI.insertData();


    }
}
