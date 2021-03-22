
package com.cwg.payment.payment_gateway.model.response.paystack;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("customer_code")
    @Expose
    private String customerCode;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("metadata")
    @Expose
    private String metadata;
    @SerializedName("risk_action")
    @Expose
    private String riskAction;
    @SerializedName("international_format_phone")
    @Expose
    private String internationalFormatPhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getRiskAction() {
        return riskAction;
    }

    public void setRiskAction(String riskAction) {
        this.riskAction = riskAction;
    }

    public String getInternationalFormatPhone() {
        return internationalFormatPhone;
    }

    public void setInternationalFormatPhone(String internationalFormatPhone) {
        this.internationalFormatPhone = internationalFormatPhone;
    }

}
