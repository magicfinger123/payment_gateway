/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.io;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuccessMessage {
    private String message;
}
