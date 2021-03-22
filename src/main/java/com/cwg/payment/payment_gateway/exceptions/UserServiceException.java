/*
 * Copyright (c) 2020. Magicfinger
 * Email: mikeossaiofficial@gmail.com
 * Tel: 07086737758
 */

package com.cwg.payment.payment_gateway.exceptions;

import lombok.Getter;

@Getter
public class UserServiceException extends RuntimeException {

    private static final Long serialVersionUID = 123425L;

    private String developerMessage;

    public UserServiceException(String usermessage, String developerMessage) {
        super(usermessage);
        this.developerMessage = developerMessage;
    }

}
