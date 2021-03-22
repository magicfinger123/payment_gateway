/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.controller;


import com.cwg.payment.payment_gateway.io.LogTimeFilter;
import com.cwg.payment.payment_gateway.model.response.ApiResponse;
import com.cwg.payment.payment_gateway.model.resquest.PaystackChargeRequest;
import com.cwg.payment.payment_gateway.model.resquest.SubmitOtp;
import com.cwg.payment.payment_gateway.service.PaystackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaystackController {
    @Autowired
    private
    PaystackService paystackService;
    @Autowired
    private
    ApiResponse apiResponse;
    @Autowired
    private
    LogTimeFilter logTimeFilter;
    @PostMapping("/charge")
    public ResponseEntity<ApiResponse> performCharge(@RequestBody PaystackChargeRequest chargeRequest)
    {
        ApiResponse apiResponse = paystackService.paystackCharge(chargeRequest);
        return ResponseEntity.status(apiResponse.getStatusCode()).body(apiResponse);
    }
    @PostMapping("/verifyOtp")
    public ResponseEntity<ApiResponse> submitOtp(@RequestBody SubmitOtp otp)
    {
        ApiResponse apiResponse = paystackService.submitOtp(otp);
        return ResponseEntity.status(apiResponse.getStatusCode()).body(apiResponse);
    }

    @PostMapping("/account_resolve")
    public ResponseEntity<ApiResponse> accountResolve(@RequestParam("accountNo") String accountNo, @RequestParam("bankCode") String bankCode)
    {
        ApiResponse apiResponse = paystackService.accountResolve(accountNo,bankCode);
        return ResponseEntity.status(apiResponse.getStatusCode()).body(apiResponse);
    }
}
