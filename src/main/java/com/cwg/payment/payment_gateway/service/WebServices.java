/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.service;

import com.cwg.payment.payment_gateway.model.response.PaystackBankResolveResponse;
import com.cwg.payment.payment_gateway.model.response.PaystackResponse;
import com.cwg.payment.payment_gateway.model.response.paystack.PaystackVerificationResponse;
import com.cwg.payment.payment_gateway.model.resquest.PaystackChargeRequest;
import com.cwg.payment.payment_gateway.model.resquest.SubmitOtp;
import retrofit2.Call;
import retrofit2.http.*;

public interface WebServices {

    @POST("charge")
    Call<PaystackResponse> payStackCharge(@Body PaystackChargeRequest chargeRequest);
    @POST("charge/submit_otp")
    Call<PaystackResponse> submitOtp(@Body SubmitOtp submitOtp);
    @GET("transaction/verify/{ref}")
    Call<PaystackVerificationResponse> verificationResponse(@Path("ref") String ref);
    @GET("resolve")
    Call<PaystackBankResolveResponse> accountResolve(@Query("account_number") String accountNo, @Query("bank_code") String banCkCode);
}
