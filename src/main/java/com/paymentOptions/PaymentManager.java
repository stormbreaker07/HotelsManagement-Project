package com.paymentOptions;

import java.util.Scanner;

public class PaymentManager {

    private Scanner scan;
    private DebitCardPayment debitCard;
    private CreditCardPayment creditCard;

    public PaymentManager(Scanner input) {
        scan = input;
        doPayment();
    }

    public void doPayment() {
        System.out.println("Choose the Payment method : ");
        System.out.println("Debit Card : type 1 for payment using debit card");
        System.out.println("Credit Card : type 2 for payment using debit card");

        String input = scan.nextLine();
        if(input.equals("1")) {
            System.out.println("input the 14 digit account Number");
            String accountNumber = scan.nextLine();
            System.out.println("input the expiry date in format month-date-year");
            String expDate = scan

        } else if(input.equals("2")) {

        } else {
            System.out.println("invalid input");
        }


    }

}
