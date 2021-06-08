package com.userInterface;

import com.database.HotelDatabase;
import com.database.PaymentTransactionDatabase;
import com.database.RegisteredUserDatabase;
import com.database.RoomsDatabase;
import com.persistDatabase.DeserializeDatabase;
import com.persistDatabase.SerializeDataBase;



import java.util.Scanner;

public class Main {

    private static HotelOwnerUi hotelOwnerUi;
    private static CustomerGui customerGui;
    private static SerializeDataBase serializeDataBase;

    public static void main(String[] args) {
       RoomsDatabase.initiate();
       PaymentTransactionDatabase.initialize();
        HotelDatabase.initiateDatabase();
        RegisteredUserDatabase.initialization();

        //deserialize database here in start
        DeserializeDatabase deserializeDatabase = new DeserializeDatabase();
        deserializeDatabase.deserializeNow();


        //update id in database
        HotelDatabase.updateId();
        RoomsDatabase.updateId();

        Scanner scan = new Scanner(System.in);
        String st = "0";

        System.out.println("HELLO USER");
        while(!st.equals("-1")) {
            System.out.println("type 1 if you are a Customer : " );
            System.out.println("type 0 if you are a hotelOwner : ");
            System.out.println("type -1 to exit from the app : ");
            st = scan.nextLine();
            if(st.equals("1")) {
                customerGui = new CustomerGui(scan);
            }
            else if(st.equals("0")) {
               hotelOwnerUi = new HotelOwnerUi(scan);
            }
            else if(st.equals("-1")) {
                serializeDataBase = new SerializeDataBase();
                System.out.println("Exiting from the App ....");
                break;
            }
            else {
                System.out.println("invalid input please try again");
            }
        }



    }
}
