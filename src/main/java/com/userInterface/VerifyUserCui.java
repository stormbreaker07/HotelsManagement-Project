package com.userInterface;

import com.customerVerification.CustomerVerificationManager;

import java.sql.SQLOutput;
import java.util.Scanner;

public class VerifyUserCui {

    private Scanner scan;
    private CustomerVerificationManager verify;

    public VerifyUserCui(Scanner scan) {
        this.scan = scan;
        verify = new CustomerVerificationManager();
    }

    public Boolean verifyUser() {
        System.out.println(" Hello User..? , we dont know you so lets start from signUp or signIn :) ");
        System.out.println("type 0 if you are new at our App : ");
        System.out.println("type 1 if you are a honourable Customer of our App : ");
        String input = " ";

        while(!input.equals("-1")) {
            input = scan.nextLine();
            if (input.equals("0")) {
                return signUp();

            } else if (input.equals("1")) {
                return signIn();

            } else if (input.equals("-1")) {
                System.out.println("thnku for using our service >>> , Exiting.....");
                return false;

            } else {
                System.out.println("invalid input");
            }
        }
        return false;
    }

    public Boolean signUp() {
        System.out.print("Full Name : ");
        String name = scan.nextLine();
        System.out.print("PhoneNumber : ");
        String phoneNumber = scan.nextLine();
        System.out.print("Email Id : ");
        String emailId = scan.nextLine();
        System.out.print("Password : ");
        String password = scan.nextLine();
        return verify.signUp(name , phoneNumber , emailId , password);
//        if(result) {
//            System.out.println("You are registered successfully");
//        }
//        else {
//            System.out.println("Technical error please try again");
//        }
    }


    public Boolean signIn() {
        System.out.print("Email Id : ");
        String emailId = scan.nextLine();
        System.out.print("Password : ");
        String password = scan.nextLine();
        return verify.signIn(emailId , password);
//        if(result) {
//            System.out.println("successfully signed Up");
//        }
//        else {
//            System.out.println("Technical error please try again after sometime");
//        }

    }

}
