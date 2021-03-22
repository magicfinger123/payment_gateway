/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.service.impl;

import com.cwg.payment.payment_gateway.exceptions.UserServiceException;
import com.cwg.payment.payment_gateway.model.response.*;
import com.cwg.payment.payment_gateway.model.response.paystack.CustomField;
import com.cwg.payment.payment_gateway.model.response.paystack.Metadata;
import com.cwg.payment.payment_gateway.model.response.paystack.PaystackVerificationResponse;
import com.cwg.payment.payment_gateway.model.resquest.PaystackChargeRequest;
import com.cwg.payment.payment_gateway.model.resquest.SubmitOtp;
import com.cwg.payment.payment_gateway.service.PaystackService;
import com.cwg.payment.payment_gateway.service.RetrofitInstance;
import com.cwg.payment.payment_gateway.service.WebServices;
import com.cwg.payment.payment_gateway.shared.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PaystackServiceImpl implements PaystackService {
    @Autowired
    ResponseBuilder responseBuilder;
    @Autowired
    private Utils utils;
    WebServices getClientDataService = RetrofitInstance.getPaystackService();
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ApiResponse paystackCharge(PaystackChargeRequest charge) {
        PaystackResponse s;
        Metadata metadata = new Metadata();
        List<CustomField> customFields = new ArrayList<>();
        CustomField customField = new CustomField("Order Request","Service","Service");
        customFields.add(customField);
        metadata.setCustomFields(customFields);
        charge.setMetadata(metadata);
        Call<PaystackResponse> performCharge = getClientDataService.payStackCharge(charge);
        try {
            Response<PaystackResponse> r  = performCharge.execute();
            s = r.body();
            if (s == null)
                throw new UserServiceException("unable to initiate charge","unable to initiate charge");
        } catch (IOException e) {
            e.printStackTrace();
            throw new UserServiceException("unable to initiate charge","unable to initiate charge");
        }
        ApiResponse apiResponse = responseBuilder.successfulResponse();
        apiResponse.responseEntity = ResponseEntity.ok(s);
        return apiResponse;
    }
    @Override
    public ApiResponse submitOtp(SubmitOtp submitOtp) {
        PaystackResponse s;
        Call<PaystackResponse> performCharge = getClientDataService.submitOtp(submitOtp);
        try {
            Response<PaystackResponse> r  = performCharge.execute();
            s = r.body();
            if (s == null)
                throw new UserServiceException("unable to initiate charge","unable to initiate charge");
        } catch (IOException e) {
            e.printStackTrace();
            throw new UserServiceException(e.getLocalizedMessage(),e.getMessage());
        }
        ApiResponse apiResponse = responseBuilder.successfulResponse();
        apiResponse.responseEntity = ResponseEntity.ok(s);
        return apiResponse;
    }

    @Override
    public ApiResponse accountResolve(String accountNo, String bankCode) {
        PaystackBankResolveResponse s;
        Call<PaystackBankResolveResponse> performCharge = getClientDataService.accountResolve(accountNo,bankCode);
        try {
            Response<PaystackBankResolveResponse> r  = performCharge.execute();
            s = r.body();
            if (s == null)
                throw new UserServiceException("unable resolve account","unable resolve account");
        } catch (IOException e) {
            e.printStackTrace();
            throw new UserServiceException("unable resolve account",e.getMessage());
        }
        ApiResponse apiResponse = responseBuilder.successfulResponse();
        apiResponse.responseEntity = ResponseEntity.ok(s);
        return apiResponse;
    }
}
