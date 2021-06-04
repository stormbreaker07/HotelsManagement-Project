package com.paymentOptions;

import com.exceptions.InvalidTransactionIdException;
import com.services.PaymentService;

import java.util.Scanner;

public class PaymentManager {

    private Payment card;
    private String amount;
    private PaymentService processPayment;

    public PaymentManager() {
        processPayment = new PaymentService();
    }

    public void doPayment(String accountNumber , String typeOfPayment , String amount) {
        if(typeOfPayment.equals("1")) {
            card = new DebitCardPayment();
            card.cardPayment(accountNumber , amount);
        }
        else {
            card = new CreditCardPayment();
            card.cardPayment(accountNumber , amount);
        }

        processPayment.addTransaction(card);


    }

    public Payment findPayment(String transactionId) {
        try {
            return processPayment.findTransaction(transactionId);
        } catch(InvalidTransactionIdException e) {
            System.out.println(e);
        }
        return null;
    }

}
