package com.paymentOptions;

import java.io.Serializable;

public interface Payment extends Serializable {

    public void cardPayment(String accountNumber , String amount );
}
