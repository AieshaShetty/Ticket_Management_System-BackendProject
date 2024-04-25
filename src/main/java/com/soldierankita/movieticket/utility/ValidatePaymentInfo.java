package com.soldierankita.movieticket.utility;

import com.soldierankita.movieticket.exception.InsufficentBalanceError;

import java.util.HashMap;
import java.util.Map;

//import com.soldierankita.movieticket.exception.InsufficentBalanceError;

public class ValidatePaymentInfo {

    private static Map<String,Double> paymentInfo= new HashMap<>();

    static {
        paymentInfo.put("acc1", 1000.0);
        paymentInfo.put("acc2", 500.0);
        paymentInfo.put("acc3", 2000.0);

    }

    public static boolean validateCreditLimit(String accNo,double paidAmount) {
        if(paidAmount > paymentInfo.get(accNo)) {
            throw new InsufficentBalanceError("Insufficent Balance!!!");
            //return false;
        }else {
            return true;
        }
    }

}
