package com.devsuperior.hrpayroll.service;

import com.devsuperior.hrpayroll.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long id, int days){
        return new Payment("Bob", 200.0, days);
    }

}
