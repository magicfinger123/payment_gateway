/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.model.resquest;


import com.cwg.payment.payment_gateway.model.response.paystack.Metadata;
import lombok.Data;

@Data
public class PaystackChargeRequest {
    private String email;
    private String amount;
    private String birthday;
    private String reference;
    private Metadata metadata;
    private BankInfo bank;
}
