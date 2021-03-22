/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.model.resquest;

import lombok.Data;

@Data
public class CustomerModel {
    private String fullName;
    private String phone;
    private String email;
    private String company;
    private String address;
    private String deliveryAddress;
    private String contactPerson;
    private String contactPersonPhone;
}
