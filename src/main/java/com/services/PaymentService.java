package com.services;


import com.database.PaymentTransactionDatabase;
import com.exceptions.InvalidTransactionIdException;
import com.paymentOptions.Payment;

/**
 * register a transaction take place here
 * it store a valid transaction in the database
 * show all the transaction take place till that instance
 */
public class PaymentService {

    public PaymentService() {}

    /**
     * add a valid transaction in database
     */
    public void addTransaction(Payment card) {
        int transactionId = card.hashCode();
        PaymentTransactionDatabase.addTransaction(String.valueOf(transactionId) , card);

    }


    /**
     * find the transaction if it is present in database using transactionId
     * @param transactionId
     * @return
     * @throws InvalidTransactionIdException
     */
    public Payment findTransaction(String transactionId) throws InvalidTransactionIdException {

            Payment transaction = PaymentTransactionDatabase.showTransaction(transactionId);
            return transaction;
    }


}
