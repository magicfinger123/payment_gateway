/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.model.response;

import lombok.Data;

@Data
public class DataInfo {
    private String reference;
    private String status;
    private String message;
}
