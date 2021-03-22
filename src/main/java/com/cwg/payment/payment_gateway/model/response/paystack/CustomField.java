
package com.cwg.payment.payment_gateway.model.response.paystack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomField {

    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("variable_name")
    @Expose
    private String variableName;


}
