package com.paymentOptions;

import java.io.Serializable;
import java.time.LocalDate;

public class CreditCardPayment implements Payment{

    private String paymentType = "Credit card";
    private String ammount ;
    private String accountNumber;
    private LocalDate paymentDate;

    public CreditCardPayment() {}

    @Override
    public void cardPayment(String accountNumber , String ammount ) {
        this.paymentDate = LocalDate.now();
        this.accountNumber = accountNumber;
        this.ammount = ammount;
    }

}
