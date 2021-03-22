/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */
package com.cwg.payment.payment_gateway.model.response;
import com.cwg.payment.payment_gateway.model.response.paystack.BankResolveDto;
import lombok.Data;

@Data
public class PaystackBankResolveResponse {
    private String Status;
    private String message;
    private BankResolveDto data;
}
