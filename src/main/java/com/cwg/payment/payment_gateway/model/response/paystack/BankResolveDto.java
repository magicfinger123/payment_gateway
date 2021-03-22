package com.cwg.payment.payment_gateway.model.response.paystack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BankResolveDto {
    @SerializedName("account_number")
    @Expose
    private String accountNumber;
    @SerializedName("account_name")
    @Expose
    private String accountName;
    @SerializedName("bank_id")
    @Expose
    private Integer bankId;
}
