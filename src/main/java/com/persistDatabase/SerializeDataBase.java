//package com.persistDatabase;
//
//import com.database.HotelDatabase;
//import com.database.PaymentTransactionDatabase;
//import com.database.RegisteredUserDatabase;
//import com.database.RoomsDatabase;
//
//import java.io.FileOutputStream;
//import java.io.ObjectOutputStream;
//
//public class SerializeDataBase {
//
//    public SerializeDataBase() {
//
//        try {
//
//
//            /**
//             * creating stream
//             */
////            FileOutputStream fileOutputStream = new FileOutputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/HotelDatabase.txt");
////            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
////            objectOutputStream.writeObject(HotelDatabase.getInstance());
////            objectOutputStream.flush();
////            objectOutputStream.close();
////            fileOutputStream = new FileOutputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/RoomsDatabase.txt");
////            objectOutputStream = new ObjectOutputStream(fileOutputStream);
////            objectOutputStream.writeObject(RoomsDatabase.getInstance());
////            objectOutputStream.flush();
////            objectOutputStream.close();
////            fileOutputStream = new FileOutputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/RegisteredUserDatabase.txt");
////            objectOutputStream = new ObjectOutputStream(fileOutputStream);
////            objectOutputStream.writeObject(RegisteredUserDatabase.getInstance());
////            objectOutputStream.flush();
////            objectOutputStream.close();
////            fileOutputStream = new FileOutputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/PaymentTransactionDatabase.txt");
////            objectOutputStream = new ObjectOutputStream(fileOutputStream);
////            objectOutputStream.writeObject(PaymentTransactionDatabase.getInstance());
////            objectOutputStream.flush();
////            objectOutputStream.close();
//
//            Example example = new Example();
//            example.addData(2 ,3);
//            example.addData(4,5);
//            example.addData(6 ,7);
//            example.addData(8,8);
//
//            FileOutputStream fileOutputStream = new FileOutputStream("/home/stormbreaker/Study/Java/Design Pattern/Hotels Management/src/main/resources/Example.txt");
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(example);
//            objectOutputStream.flush();
//            objectOutputStream.close();
//
//        } catch(Exception e) {
//            System.out.println("Persisting Database Process Failed");
//        }
//    }
//}
