//package com.persistDatabase;
//
//import com.database.HotelDatabase;
//import com.database.PaymentTransactionDatabase;
//import com.database.RegisteredUserDatabase;
//import com.database.RoomsDatabase;
//
//import java.io.FileInputStream;
//import java.io.ObjectInputStream;
//
//public class DeserializeDatabase {
//
//    private HotelDatabase hotelDatabase;
//    private RoomsDatabase roomsDatabase;
//    private PaymentTransactionDatabase paymentTransactionDatabase;
//    private RegisteredUserDatabase registeredUserDatabase;
//
//    private Example example ;
//
//    public DeserializeDatabase() {}
//
//    public void deserializeNow()
//    {
//
//        try {
////            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/HotelDatabase.txt"));
////            hotelDatabase = (HotelDatabase) objectInputStream.readObject();
////            objectInputStream = new ObjectInputStream(new FileInputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/RoomsDatabase.txt"));
////            roomsDatabase = (RoomsDatabase) objectInputStream.readObject();
////            objectInputStream = new ObjectInputStream(new FileInputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/registeredUserDatabase.txt"));
////            registeredUserDatabase = (RegisteredUserDatabase)objectInputStream.readObject();
////            objectInputStream = new ObjectInputStream(new FileInputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/PaymentTransactionDatabase.txt"));
////            paymentTransactionDatabase = (PaymentTransactionDatabase) objectInputStream.readObject();
//
//            ObjectInputStream read = new ObjectInputStream(new FileInputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/Example.txt"));
//            Example example = (Example) read.readObject();
//            example.addData(2 , 3);
//            example.showData();
//        }
//        catch(Exception e) {
//            System.out.println("Deserialization Process Not successful");
//        }
//    }
//
//    public Example getIt() {
//        return example;
//    }
//}
