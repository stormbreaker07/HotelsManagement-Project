package com.database;


import com.exceptions.InvalidTransactionIdException;
import com.hotel.HotelInterface;
import com.paymentOptions.Payment;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * singleton class use to store the payment transaction data in the hashMap
 *
 */
public class PaymentTransactionDatabase implements Serializable {


    private static PaymentTransactionDatabase instance = null;
    private static Map<String , Payment> data = null;

    /**
     * private constructor
     */
    private PaymentTransactionDatabase() {
        initialize();
    }

    public static void initiateDatabase(Map<String , Payment> newData) {
        data = newData;
    }


    /**
     * return class object instance
     * @return object reference
     */
    public static PaymentTransactionDatabase getInstance() {
        if(instance == null) {
            instance = new PaymentTransactionDatabase();
        }
        return instance;

    }

    /**
     * initialize the data storing map
     * the mappind take is  like
     * key = transaction id
     * value = Payment object
     */
    public static void initialize() {
        if(data == null) {
            data = new HashMap<String , Payment>();
        }
    }



    public static void addTransaction(String transactionId , Payment payment) {
        data.put(transactionId , payment);
    }


    /**
     * show transaction related to transaction id
     * @param transactionId
     */
    public static Payment showTransaction(String transactionId) throws InvalidTransactionIdException {
        Payment transaction = data.get(transactionId);
        if(transaction != null) {
            return transaction;
        }
        else {
            throw new InvalidTransactionIdException("transaction with this id doesnt exist !");
        }
    }

    public static HashMap<String , Payment> allTransaction() {

        return (HashMap<String, Payment>) data;
    }
}
