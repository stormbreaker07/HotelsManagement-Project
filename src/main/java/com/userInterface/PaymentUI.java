package com.userInterface;


import com.paymentOptions.PaymentManager;

import java.util.Scanner;

/**
 * it works as user Interface between user and Payment Manager
 */
public class PaymentUI {

    private Scanner scan;
    private PaymentManager paymentManager;
    private String amount;

    public PaymentUI(Scanner input , String amount) {
        scan = input;
        paymentManager = new PaymentManager();
        this.amount = amount;

    }

    public void insertData() {
        System.out.println("Choose the Payment method : ");
        System.out.println("Debit Card : type 1 for payment using debit card");
        System.out.println("Credit Card : type 2 for payment using debit card");

        String input = scan.nextLine();
        if(input.equals("2") || input.equals("1")) {
            String accountNumber = paymentInformation();
            paymentManager.doPayment(accountNumber , input , amount);

        } else {
            System.out.println("invalid input");
        }

    }

    public String paymentInformation() {
        System.out.println("input the 14 digit account Number");
        String accountNumber = scan.nextLine();
        System.out.println("input the expiry date in format month-date-year");
        String expDate = scan.nextLine();
        System.out.println("input your cvv code");
        String securityCode = scan.nextLine();
        return accountNumber;
    }


}
