package com.paymentOptions;

import java.io.Serializable;
import java.time.LocalDate;

public class DebitCardPayment implements Payment {

    private String paymentType = "Debit card";
    private String accountNumber;
    private String ammount;
    private LocalDate paymentDate;

    public DebitCardPayment() {}

    public void cardPayment(String accountNumber , String amount) {
        this.ammount = amount;
        this.accountNumber = accountNumber;
        this.paymentDate = LocalDate.now();
    }

}
