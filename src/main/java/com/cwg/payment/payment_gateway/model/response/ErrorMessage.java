/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.model.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorMessage {
    private int StatusCode;
    private int errorCode;
    private String developerMessage;
    private String userMessage;
}
