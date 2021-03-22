/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.model.response;

import java.util.List;

public class OrderRest {
    public String orderId;
    public String userId;
    public String customerId;
    public String totalAmount;
    public String orderStatus;
    public String orderDate;
    public String tax;
    public List<OrderItemRest> items;
    public CustomerRest customerRest;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItemRest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRest> items) {
        this.items = items;
    }

    public CustomerRest getCustomerRest() { return customerRest; }

    public void setCustomerRest(CustomerRest customerRest) { this.customerRest = customerRest; }

    public String getOrderDate() { return orderDate; }

    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTax() { return tax; }

    public void setTax(String tax) {
        this.tax = tax;
    }
}
