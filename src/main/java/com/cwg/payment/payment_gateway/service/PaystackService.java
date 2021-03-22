/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.service;


import com.cwg.payment.payment_gateway.model.response.ApiResponse;
import com.cwg.payment.payment_gateway.model.response.OrderRest;
import com.cwg.payment.payment_gateway.model.resquest.PaystackChargeRequest;
import com.cwg.payment.payment_gateway.model.resquest.SubmitOtp;

public interface PaystackService {
    ApiResponse paystackCharge(PaystackChargeRequest charge);
    ApiResponse submitOtp(SubmitOtp submitOtp);
    ApiResponse accountResolve(String accountNo, String bankCode);
}
