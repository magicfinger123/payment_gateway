/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.model.resquest;

import lombok.Data;

import java.util.List;

@Data
public class OrderModel {
    private String orderId;
    private String userId;
    private String totalAmount;
    private String orderStatus;
    private List<OrderItemModel> items;
    private CustomerModel customerModel;
}
