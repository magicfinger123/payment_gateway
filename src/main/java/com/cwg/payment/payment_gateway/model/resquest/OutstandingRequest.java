/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.model.resquest;

import lombok.Data;

import java.sql.Date;

@Data
public class OutstandingRequest {
    public static final long serialVersionUID = 6411563565645445491L;
    private String  clientId;
    private String clientName;
    private String companyName;
    private String description;
    private String invoicedAmount;
    private String amountPaid;
    private String user;
    private String balance;
    private Date lastFDate;
    private Date nextFDate;
    private Date date;
    private int visible;
}
